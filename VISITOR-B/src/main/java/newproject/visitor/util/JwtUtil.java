package newproject.visitor.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import newproject.visitor.model.Employee;
import newproject.visitor.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;
@Component
public class JwtUtil {
    @Autowired
    private EmployeeRepository employeeRepository;
    private static String secret = "This is the secret message for generating token";
    private long expiryDuration =60*60;
    public String generateToken(String Email) {
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration*1000;
        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);
        return Jwts.builder().subject(Email)
                .issuedAt(issuedAt)
                .expiration(expiryAt).signWith(SignatureAlgorithm.HS256, secret.getBytes(StandardCharsets.UTF_8)).compact();
    }
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        System.out.println(claims.getSubject());
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token)
    {
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), sa.getJcaName());
        return Jwts
                .parser()
                .verifyWith(secretKeySpec)
                .build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    public boolean isEmail(String email)
    {
        Employee employee=employeeRepository.findByMailId(email);
        return employee!=null;
    }
    public boolean validateToken(String token) {
        String tokenEmail = extractEmail(token);
        boolean isTokenExpired=isTokenExpired(token);
        return (isEmail(tokenEmail) && !isTokenExpired);
    }
}




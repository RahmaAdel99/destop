import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.*;
public class signEx {

     public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            String soapRequest = "<Message><NetworkManagement.LogOn.Requests><Data><Header><Version>1.00</Version><ClientId>bcaa6fcc-6671-4822-ac16-9b413a7a6b6d</ClientId><RequestId>50a293ff-b21f-42d3-b233-2150f271216f</RequestId><RequestTimeStamp>2023-11-11T05:25:39Z</RequestTimeStamp></Header><Body><Online>true</Online></Body></Data></NetworkManagement.LogOn.Requests></Message>";

            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hash = digest.digest(soapRequest.getBytes(StandardCharsets.UTF_8));

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(hash);
            byte[] digitalSignature = signature.sign();

            Signature verificationSignature = Signature.getInstance("SHA256withRSA");
            verificationSignature.initVerify(publicKey);
            verificationSignature.update(hash);
            boolean verified = verificationSignature.verify(digitalSignature);

            System.out.println("Signature: " + Base64.getEncoder().encodeToString(digitalSignature));
            System.out.println("Verified: " + verified);
        }
    }


import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class digisignature {
    public static void main(String[] args) throws Exception {
        // Private Key
        String privateKeyStr = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDTv8ivMzhfbnpqTEba4ev1OXTz+rtF2FRHD5j03RnntjT26O+dgiweQiMTt1GPE0pHc0FEEx1cjlSBzLZJdkbuDA38mzH0ldN2zzuxDbHYm0GgXjhYTkBnv7KuSLEaaNw3lvq+W73XHAT55QjC2IMPiZTWeemyQli6GlgRloORraZsz6vYEhfnhvV2FWJ/uqXrAKp9C6AOOmpIedumKMLo4cROMqifyVq5p9wEtslc2jB9tGdYbfu9vvzCmAIWgkUyA3wy+Vf2SpdvkU0OpMH/CcpuLUa1ItKy0U5BNFFigRVVpTLR7CQoLE16xfTcX4k4FidfyfRCTyFDDkGv4G3HAgMBAAECggEAI90rxGDMf31axn480f3J1TLyGBCzf1TwkUiXA4IfTRuTRO6XBvpxNn7FKiW2bqE5x3hB6aHDK1YAAiwGA9NAmDj6dXpjr6Vgt5LJ7WcAZEuHhf3vVSWLywaw4Mv3Ex4HjnLH7U3kjXZ1cU3Vegrpx8vppZnodwS9umeT2wa/KgEMQfeheqMc+QffKgTpSxWIbYWgyScgv5UtKsoA9wkiP5BpN6NVfR+b/8lrpJN+R9w/C9jUZ2vRxNU+4MwBNr6jHE5e52nR9tI+YTECS2NC22HMF+YfJirPxY/4seqfuJCGi5+G/ohTNVNYdEh9lGD2EifpUoxhUIuhRYyAPBTUwQKBgQD7RdUSuTyjOd+RTjl8+nQWJ/8Isl4ajbft9Qyi2S8EfUklDJI823xGycbxYrbZI0riOZDLrkn/FPS0zCa8JECb4ZvqgQCgE89Lfbv/YHqWDY238moij2qAv8mp57PMVCBXk7CapfNWUrPIyN94s50RMN1xMq5/igDlOwdWsBjCWQKBgQDXu5mPwCtaA50N8s/rbMN7fPCDGY40QesVGK5bjkmyaVIfk/7E3zaiew3y47QKiBm1lid6FDm7JSs+sLm8tCyVx+3oGCucGhrdiCBQ/gTxNbx584v/DiaET3j3y1tlhkzV1QD89Lp+XdpbX93FM/SwmWVIEAIulj4kBMHfRQltHwKBgQChvl/bv5VC1JwO4rWqt2VGZdSK+pYMrbD54cWShg736tXMnXz846PpxTTkaNCekVNAsCF+muBS7GBgiRFeBk/4h49fsk5+vIGxbGw5hRcjw/G3uLmNKZg67DmZvuZD3ts6xHzn727l4DKOSo9fGO9AA55noWImAuV0qTyeFpi5cQKBgQCnONOfieYQsBxdY4mng3dDkWUdOgHwn+gJQkhkz7ZwhRMTRzSEhkFjUN9PFxHH2BeVmf6fsm3NktIilfpjO4YT1BWlgpbLObD5ZzsljMFn969RGGe8HMveY3vxF8CQwbltRt6tNUYaDcXkbjsJUWyqNz06zq3iTrN8V/OvjWPxIQKBgFSDNNfjcyMAIe4DXxK2XqaVPPT9Er29ikyl8CNnRqVtPeu3dKvPLwX+9ZxxP3IUXgeM4LiaKE9R24owY0gkLjUv6RcEc53sIi6vxuDYr4EylMr4HFFtEUZfehHJr//nTYqKCcvCV4oh7wXFlzoiQ+olJPqTua50d9FSCQt9sSPG";

        // Public Key
        String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA07/IrzM4X256akxG2uHr9Tl08/q7RdhURw+Y9N0Z57Y09ujvnYIsHkIjE7dRjxNKR3NBRBMdXI5Ugcy2SXZG7gwN/Jsx9JXTds87sQ2x2JtBoF44WE5AZ7+yrkixGmjcN5b6vlu91xwE+eUIwtiDD4mU1nnpskJYuhpYEZaDka2mbM+r2BIX54b1dhVif7ql6wCqfQugDjpqSHnbpijC6OHETjKon8lauafcBLbJXNowfbRnWG37vb78wpgCFoJFMgN8MvlX9kqXb5FNDqTB/wnKbi1GtSLSstFOQTRRYoEVVaUy0ewkKCxNesX03F+JOBYnX8n0Qk8hQw5Br+BtxwIDAQAB";

        // Data to sign
        String data = "<NetworkManagement.LogOn.Requests>\n" +
                "<Data>\n" +
                "<Header>\n" +
                "<Version>1.00</Version>\n" +
                "<ClientId>bcaa6fcc-6671-4822-ac16-9b413a7a6b6d</ClientId>\n" +
                "<RequestId>50a823ff-b21f-42d3-b233-2199f271216f</RequestId>\n" +
                "<RequestTimeStamp>2023-11-13T05:10:39Z</RequestTimeStamp>\n" +
                "</Header>\n" +
                "<Body>\n" +
                "<Online>true</Online>\n" +
                "</Body>\n" +
                "</Data>\n" +
                "</NetworkManagement.LogOn.Requests>";

        // Generate DigestValue
        String digestValue = generateDigestValue(data);

        // Generate digital signature
        String signatureValue = generateDigitalSignature(digestValue, privateKeyStr);

        // Verify the signature
        boolean isVerified = verifyDigitalSignature(digestValue, signatureValue, publicKeyStr);

        System.out.println("DigestValue: " + digestValue);
        System.out.println("SignatureValue: " + signatureValue);
        System.out.println("Verification Result: " + isVerified);
    }

    private static String generateDigestValue(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    private static String generateDigitalSignature(String data, String privateKeyStr) throws Exception {
        Signature signature = Signature.getInstance("SHA1withRSA");

        // Load private key
        privateKeyStr = privateKeyStr.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Initialize Signature with private key
        signature.initSign(privateKey);

        // Update data to be signed
        signature.update(data.getBytes(StandardCharsets.UTF_8));

        // Generate signature
        byte[] signatureBytes = signature.sign();

        // Encode signature as Base64
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    private static boolean verifyDigitalSignature(String data, String signatureValue, String publicKeyStr) throws Exception {
        Signature signature = Signature.getInstance("SHA1withRSA");

        // Load public key
        publicKeyStr = publicKeyStr.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Initialize Signature with public key
        signature.initVerify(publicKey);

        // Update data to be verified
        signature.update(data.getBytes(StandardCharsets.UTF_8));

        // Decode signature value from Base64
        byte[] signatureBytes = Base64.getDecoder().decode(signatureValue);

        // Verify the signature
        return signature.verify(signatureBytes);
    }
}
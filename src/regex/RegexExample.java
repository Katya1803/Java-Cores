package regex;

import a.example.Example;
import java.util.Arrays;
import java.util.List;

public class RegexExample implements Example {
    @Override
    public void run() {
        List<String> emails = Arrays.asList(
                "test@example.com",
                "invalid-email.com",
                "another.test@domain.co",
                "wrong@domain",
                "user@domain.c",
                "valid.email@domain.com"
        );

        List<String> phoneNumbers = Arrays.asList(
                "123-456-7890",
                "123.456.7890",
                "1234567890",
                "123-45-6789"
        );

        List<String> zipCodes = Arrays.asList(
                "12345",
                "12345-6789",
                "1234",
                "12345-678"
        );

        List<String> urls = Arrays.asList(
                "http://example.com",
                "https://www.example.com/path?query=param",
                "www.example.com",
                "example.com"
        );

        List<String> ipAddresses = Arrays.asList(
                "192.168.0.1",
                "255.255.255.255",
                "256.256.256.256",
                "192.168.0"
        );

        RegexValidator validator = new RegexValidator();

        System.out.println("Email Validation:");
        emails.forEach(email -> System.out.println(email + ": " + validator.isValidEmail(email)));

        System.out.println("\nPhone Number Validation:");
        phoneNumbers.forEach(phone -> System.out.println(phone + ": " + validator.isValidPhoneNumber(phone)));

        System.out.println("\nZIP Code Validation:");
        zipCodes.forEach(zip -> System.out.println(zip + ": " + validator.isValidZipCode(zip)));

        System.out.println("\nURL Validation:");
        urls.forEach(url -> System.out.println(url + ": " + validator.isValidURL(url)));

        System.out.println("\nIP Address Validation:");
        ipAddresses.forEach(ip -> System.out.println(ip + ": " + validator.isValidIPAddress(ip)));
    }
}

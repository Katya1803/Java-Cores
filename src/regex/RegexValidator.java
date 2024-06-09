package regex;

import java.util.regex.Pattern;

public class RegexValidator {
    private static final String EMAIL_REGEX = "[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\d{3}[-.]?\\d{3}[-.]?\\d{4}$";
    private static final String ZIPCODE_REGEX = "^\\d{5}(-\\d{4})?$";
    private static final String URL_REGEX = "^(https?://)?(www\\.)?[\\w.-]+\\.[a-zA-Z]{2,6}(/\\S*)?$";
    private static final String IP_ADDRESS_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private final Pattern emailPattern;
    private final Pattern phonePattern;
    private final Pattern zipCodePattern;
    private final Pattern urlPattern;
    private final Pattern ipAddressPattern;

    public RegexValidator() {
        this.emailPattern = Pattern.compile(EMAIL_REGEX);
        this.phonePattern = Pattern.compile(PHONE_REGEX);
        this.zipCodePattern = Pattern.compile(ZIPCODE_REGEX);
        this.urlPattern = Pattern.compile(URL_REGEX);
        this.ipAddressPattern = Pattern.compile(IP_ADDRESS_REGEX);
    }

    public boolean isValidEmail(String email) {
        return email != null && emailPattern.matcher(email).matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phonePattern.matcher(phoneNumber).matches();
    }

    public boolean isValidZipCode(String zipCode) {
        return zipCode != null && zipCodePattern.matcher(zipCode).matches();
    }

    public boolean isValidURL(String url) {
        return url != null && urlPattern.matcher(url).matches();
    }

    public boolean isValidIPAddress(String ipAddress) {
        return ipAddress != null && ipAddressPattern.matcher(ipAddress).matches();
    }
}



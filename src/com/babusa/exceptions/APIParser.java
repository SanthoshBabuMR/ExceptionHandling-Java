package com.babusa.exceptions;

public class APIParser {
	public static final int parseSendResponseCode(String response, String data, String partner) throws APIFormatChangeException {
		int responseCode = -1;
		try {
			String startTag = "<code>";
			String endTag = "</code>";
			if (response.contains(startTag)) {
				int beginIndex = response.indexOf(startTag) + startTag.length();
				int endIndex = response.indexOf(endTag);
				System.out.println("code: " + response.substring(beginIndex, endIndex));
				responseCode = Integer.parseInt(response.substring(beginIndex, endIndex));
			}
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			throw new APIFormatChangeException(response, "code", partner);
			// throw new APIFormatChangeException("Response :" + response + " , Element: code , Partner: " + partner);
		}
		return responseCode;
	}
}

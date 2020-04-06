package testing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class testMethods {
	
	@Test
	public void testValid() {
    //assertEquals(true, testMethods..isValid("()"));
    Assert.assertTrue(this.isValid("{}{}"));
	}
	
	public boolean isValid (String braces) {
		boolean isValid = true;
		char[] chars = braces.toCharArray();
		
		for(int i=0; i < chars.length; i++) {
			if(chars[i] == '{') {
				System.out.println("Found an open brace at [" + i + "]");
				if(i+1 < chars.length) {
					for(int e = i+1; e < chars.length; e++) {
						if(chars[e] == '}') {
							i = e;
							System.out.println("Found a close brace at [" + i + "]");
							break;
						}else {
							System.out.println("Found an open brace at [" + e + "]");
							if(e+1 < chars.length) {
								boolean foundClosingBrace = false;
								int p = 0;
								for(p = e+1; p < chars.length; p++) {
									if(chars[p] == '}') {
										e = p;
										System.out.println("Found a close brace at [" + e + "]");
										foundClosingBrace = true;
										break;
									}else {
										System.out.println("Found an open brace at [" + p + "]");
									}
								}
								if(! foundClosingBrace) {
									System.out.println("Expected a closing brace to match index [" + p + "]");
									isValid = false;
								}
							}else if(e+1 == chars.length){
								if(chars[e] != '}') {
									System.out.println("Expected a closing brace at index [" + i + "] found a [" + chars[i] + "] instead.");
									isValid = false;
								}
							}
						}
					}
				}else if(i+1 == chars.length){
					if(chars[i] != '}') {
						System.out.println("Expected a closing brace at index [" + i + "] found a [" + chars[i] + "] instead.");
						isValid = false;
					}
				}
			}else if(chars[i] == '}'){
				System.out.println("Found a closing brace without an opening brace");
				isValid = false;
			}else {
				System.out.println("Found an invalid character [" + chars[i] + "]");
				isValid = false;
			}
		}
		return isValid;
	}
}

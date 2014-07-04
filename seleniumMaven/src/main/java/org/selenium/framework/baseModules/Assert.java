package org.selenium.framework.baseModules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudheerl on 6/11/14.
 */
public class Assert extends org.testng.Assert {
    private Map<AssertionError, String> m_messages = new HashMap<>();


    public void assertTrueContinue(boolean condition, String message){
        try {
            assertTrue(condition, message);
        } catch (AssertionError e){
            m_messages.put(e, message);
        }
    }

    public void assertAll(){
        if( !m_messages.isEmpty()){
            StringBuilder sb = new StringBuilder("The following asserts failed: ");
            boolean first = true;
            for(Map.Entry<AssertionError, String> ae: m_messages.entrySet()){
                if(first) {
                    first = false;
                }else{
                    sb.append(",");
                }
                sb.append(ae.getValue() + "::" + ae.getKey());
            }
            throw new AssertionError(sb.toString());
        }
    }
}

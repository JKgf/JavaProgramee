package com.xinrui.code.url.handler;

public enum MessageBuilderEnum {  
	  
    RESET_PASSWORD_SMS(ResetPwSmsMsgSendServiceImpl.class),  
    RESET_PASSWORD_EMAIL(ResetPwMailMsgSendServiceImpl.class),  
    SMS_FEE(SmsFeeMsgSendServiceImpl.class),  
    TEMP_CODE_SMS(TempCodeSmsMsgSendServiceImpl.class),  
    UNIVERSAL_SMS(BoundMsgSendServiceImpl.class);  
      
    private Class<?> builderClass;  
      
    MessageBuilderEnum(Class<?> builderClass) {  
        this.builderClass = builderClass;  
    }  
      
    public Class<?> getBuidlerClass() {  
        return builderClass;  
    }  
} 
package com.xinrui.code.url.handler;

private static ConcurrentHashMap<String, AbstractMsgSendServiceImpl> messageBuilder = new ConcurrentHashMap<String, AbstractMsgSendServiceImpl>();  

public MessageSendServiceImpl() {  
    for (MessageBuilderEnum builderClass : MessageBuilderEnum.values()) {  
        try {  
            messageBuilder.put(builderClass.getBuidlerClass().getSimpleName(),  
                    (AbstractMsgSendServiceImpl) builderClass.getBuidlerClass().newInstance());  
        } catch (InstantiationException e) {  
            logger.error(e.getMessage(), e);  
        } catch (IllegalAccessException e) {  
            logger.error(e.getMessage(), e);  
        }  
    }  
}  
  
@Override  
public String send(ServMessage message, MessageBuilderEnum builderEnum) {  
    AbstractMsgSendServiceImpl builder = messageBuilder  
            .get(builderEnum.getBuidlerClass().getSimpleName()).clone();  
    if (builder != null) {  
        return builder.send(message);  
    } else {  
        return null;  
    }  
}  
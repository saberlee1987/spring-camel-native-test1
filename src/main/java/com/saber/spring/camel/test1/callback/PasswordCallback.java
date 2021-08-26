package com.saber.spring.camel.test1.callback;

import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.wss4j.common.WSS4JConstants;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class PasswordCallback implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callbacks[0];
                wsPasswordCallback.setIdentifier("tejaratbank");
                wsPasswordCallback.setPassword("321789");

    }
}

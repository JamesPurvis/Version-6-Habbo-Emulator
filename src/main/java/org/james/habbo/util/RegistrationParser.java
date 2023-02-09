package org.james.habbo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.types.Request;

import java.util.HashMap;

public class RegistrationParser
{
    private static Logger mLogger = LogManager.getLogger(RegistrationParser.class.getName());
    public static HashMap<Integer, Object> returnPropertyBox(Request request)
    {
        HashMap<Integer, Object> mPropertyBox = new HashMap<>();

                /*  pRegMsgStruct["parentagree"] = [#id: 1, "type": #boolean]
        pRegMsgStruct["name"] = [#id: 2, "type": #string]
        pRegMsgStruct["password"] = [#id: 3, "type": #string]
        pRegMsgStruct["figure"] = [#id: 4, "type": #string]
        pRegMsgStruct["sex"] = [#id: 5, "type": #string]
        pRegMsgStruct["customData"] = [#id: 6, "type": #string]
        pRegMsgStruct["email"] = [#id: 7, "type": #string]
        pRegMsgStruct["birthday"] = [#id: 8, "type": #string]
        pRegMsgStruct["directMail"] = [#id: 9, "type": #boolean]
        pRegMsgStruct["has_read_agreement"] = [#id: 10, "type": #boolean]
        pRegMsgStruct["isp_id"] = [#id: 11, "type": #string]
        pRegMsgStruct["partnersite"] = [#id: 12, "type": #string]
        pRegMsgStruct["oldpassword"] = [#id: 13, "type": #string]
        registerMessage(#enterRoom, me.getID(), #closeFigureCreator)
        registerMessage(#changeRoom, me.getID(), #closeFigureCreator)
        registerMessage(#leaveRoom, me.getID(), #closeFigureCreator)
        registerMessage(#show_registration, me.getID(), #openFigureCreator)
        registerMessage(#hide_registration, me.getID(), #closeFigureCreator)
        registerMessage(#figure_ready, me.getID(), #figureSystemReady) */

        while(request.remainingBytes().length > 0) {
            int mPropertyValue = request.readBase64();

            switch (mPropertyValue) {
                case 1:
                    mPropertyBox.put(mPropertyValue, request.readBytes(1)[0] == 'A');
                    break;

                case 2:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 3:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 4:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 5:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 6:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 7:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 8:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 9:
                    mPropertyBox.put(mPropertyValue, request.readBytes(1)[0] == 'A');
                    break;

                case 10:
                    mPropertyBox.put(mPropertyValue, request.readBytes(1)[0] == 'A');
                    break;

                case 11:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 12:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

                case 13:
                    mPropertyBox.put(mPropertyValue, request.popString());
                    break;

            }
        }

        return mPropertyBox;
    }
}

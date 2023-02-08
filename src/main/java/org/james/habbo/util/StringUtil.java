package org.james.habbo.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtil
{
    public static Charset getEncoding()
    {
        return StandardCharsets.ISO_8859_1;
    }


    public static boolean filterWords(String name)
    {
        for(String word : returnBadWords())
        {
            if (name.toLowerCase().contains(word.toLowerCase()))
            {
                return false;
            }
        }

        return true;
    }

    public static String[] returnBadWords()
    {
        return new String[] {
                "SHIT",
                "BITCH",
                "ADMIN",
                "MOD",
                "Administrator",
                "Moderator",
        };
    }
}

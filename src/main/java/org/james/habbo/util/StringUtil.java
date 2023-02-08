package org.james.habbo.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtil
{
    public static Charset getEncoding()
    {
        return StandardCharsets.ISO_8859_1;
    }


    public static boolean filterName(String name)
    {
        for(String word : returnBadWords())
        {
            if (name.toLowerCase().contains(word.toLowerCase()) || name.toLowerCase().startsWith("admin") || name.toLowerCase().startsWith("mod"))
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
                "Administrator",
                "Moderator",
        };
    }
}

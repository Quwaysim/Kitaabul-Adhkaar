package com.amc.astc.adhkaar.utils;

import android.content.Context;

import com.amc.astc.adhkaar.R;

//This class fetches the correct string array to be passed as an intent extra
//to an activity
public class MyResources {

    public String[] getAdhkarStringArray(int position, Context c) {
        switch (position) {
            case 0:
                return c.getResources().getStringArray(R.array.asq);
            case 1:
                return c.getResources().getStringArray(R.array.asss);
            case 2:
                return c.getResources().getStringArray(R.array.am);
            case 3:
                return c.getResources().getStringArray(R.array.abks);
            case 4:
                return c.getResources().getStringArray(R.array.absi);
            case 5:
                return c.getResources().getStringArray(R.array.an);
        }
        return null;
    }

    public String[] getSuwarStringArray(int position, Context c) {
        switch (position) {
            case 0:
                return c.getResources().getStringArray(R.array.faatihah);
            case 1:
                return c.getResources().getStringArray(R.array.sajdah);
            case 2:
                return c.getResources().getStringArray(R.array.rahmaan);
            case 3:
                return c.getResources().getStringArray(R.array.mulk);
            case 4:
                return c.getResources().getStringArray(R.array.feel);
            case 5:
                return c.getResources().getStringArray(R.array.quraysh);
            case 6:
                return c.getResources().getStringArray(R.array.maun);
            case 7:
                return c.getResources().getStringArray(R.array.kauthar);
            case 8:
                return c.getResources().getStringArray(R.array.kaafirun);
            case 9:
                return c.getResources().getStringArray(R.array.nasr);
            case 10:
                return c.getResources().getStringArray(R.array.masad);
            case 11:
                return c.getResources().getStringArray(R.array.ikhlas);
            case 12:
                return c.getResources().getStringArray(R.array.falaq);
            case 13:
                return c.getResources().getStringArray(R.array.naas);
        }
        return null;
    }

    public String[] getHadithStringArray(int position, Context c) {
        switch (position) {
            case 0:
                return c.getResources().getStringArray(R.array.forty_hadith_overview);
            case 1:
                return c.getResources().getStringArray(R.array.hadith1);
            case 2:
                return c.getResources().getStringArray(R.array.hadith2);
            case 3:
                return c.getResources().getStringArray(R.array.hadith3);
            case 4:
                return c.getResources().getStringArray(R.array.hadith4);
            case 5:
                return c.getResources().getStringArray(R.array.hadith5);
            case 6:
                return c.getResources().getStringArray(R.array.hadith6);
            case 7:
                return c.getResources().getStringArray(R.array.hadith7);
            case 8:
                return c.getResources().getStringArray(R.array.hadith8);
            case 9:
                return c.getResources().getStringArray(R.array.hadith9);
            case 10:
                return c.getResources().getStringArray(R.array.hadith10);
            case 11:
                return c.getResources().getStringArray(R.array.hadith11);
            case 12:
                return c.getResources().getStringArray(R.array.hadith12);
            case 13:
                return c.getResources().getStringArray(R.array.hadith13);
            case 14:
                return c.getResources().getStringArray(R.array.hadith14);
            case 15:
                return c.getResources().getStringArray(R.array.hadith15);
            case 16:
                return c.getResources().getStringArray(R.array.hadith16);
            case 17:
                return c.getResources().getStringArray(R.array.hadith17);
            case 18:
                return c.getResources().getStringArray(R.array.hadith18);
            case 19:
                return c.getResources().getStringArray(R.array.hadith19);
            case 20:
                return c.getResources().getStringArray(R.array.hadith20);
            case 21:
                return c.getResources().getStringArray(R.array.hadith21);
            case 22:
                return c.getResources().getStringArray(R.array.hadith22);
            case 23:
                return c.getResources().getStringArray(R.array.hadith23);
            case 24:
                return c.getResources().getStringArray(R.array.hadith24);
            case 25:
                return c.getResources().getStringArray(R.array.hadith25);
            case 26:
                return c.getResources().getStringArray(R.array.hadith26);
            case 27:
                return c.getResources().getStringArray(R.array.hadith27);
            case 28:
                return c.getResources().getStringArray(R.array.hadith28);
            case 29:
                return c.getResources().getStringArray(R.array.hadith29);
            case 30:
                return c.getResources().getStringArray(R.array.hadith30);
            case 31:
                return c.getResources().getStringArray(R.array.hadith31);
            case 32:
                return c.getResources().getStringArray(R.array.hadith32);
            case 33:
                return c.getResources().getStringArray(R.array.hadith33);
            case 34:
                return c.getResources().getStringArray(R.array.hadith34);
            case 35:
                return c.getResources().getStringArray(R.array.hadith35);
            case 36:
                return c.getResources().getStringArray(R.array.hadith36);
            case 37:
                return c.getResources().getStringArray(R.array.hadith37);
            case 38:
                return c.getResources().getStringArray(R.array.hadith38);
            case 39:
                return c.getResources().getStringArray(R.array.hadith39);
            case 40:
                return c.getResources().getStringArray(R.array.hadith40);
            case 41:
                return c.getResources().getStringArray(R.array.hadith41);
            case 42:
                return c.getResources().getStringArray(R.array.hadith42);
        }
        return null;
    }
}

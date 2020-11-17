package com.molfar.tourisminukraine.Common;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.molfar.tourisminukraine.model.CategoryModel;
import com.molfar.tourisminukraine.model.PlaceModel;
import com.molfar.tourisminukraine.model.User;
import com.molfar.tourisminukraine.model.UserModel;

public class Common {
    public static final String POPULAR_CATEGORY_REF = "MostPopular";
    public static final String USER_REFERENCES = "Users";
    public static final String BEST_PLACE_REF = "BestDeals";
    public static final int DEFAULT_COLUMN_COUNT = 0;
    public static final int FULL_WIDTH_COLUMN = 1;
    public static final String CATEGORY_REF = "Category";
    public static final String COMMENT_REF = "Comments";
    public static User currenrUser; //для старої реєстрації
    public static CategoryModel categorySelected;
    public static PlaceModel selectedPlace;
    public static UserModel currentUser2; //для нової реєстрації

    public static void setSpanString(String welcome, String name, TextView textView) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(welcome);
        SpannableString spannableString = new SpannableString(name);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, 0, name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(spannableString);
        textView.setText(builder,TextView.BufferType.SPANNABLE);
    }
}

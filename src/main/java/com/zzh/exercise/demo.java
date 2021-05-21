package com.zzh.exercise;

import com.zzh.exercise.entity.Person;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "compensation_amount","view_count","thousand_display_price","view_user_count","avg_view_per_user","valid_click_count",
                "click_user_count","ctr","cpc","valuable_click_count","valuable_click_cost","click_image_count","image_click_user_count",
                "video_play_count","video_click_user_count","click_detail_count","link_click_user_count","click_head_count",
                "portrait_click_user_count","click_nick_count","nickname_click_user_count","platform_page_view_count",
                "platform_key_page_view_user_count","platform_key_page_view_duration","cpn_click_button_count","cpn_click_button_uv",
                "praise_count","praise_user_count","comment_count","comment_user_count","conversions_count","conversions_cost",
                "conversions_rate","official_account_follow_count","official_account_follow_cost","official_account_follow_rate",
                "official_account_reader_count","no_interest_count","daily_budget");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String up = StringUtils.upperCase(s);
            String results = "String "+up + " = \""+s+"\";";
            result.add(results);
        }
        System.out.println(result);
    }

    public static void doSomthing(Person person){
        System.out.println(RandomUtils.nextLong());
    }

    public static String upCase(String str){

        return StringUtils.upperCase(str);
    }

}

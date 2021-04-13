package com.mjsoft;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.path.PathCompiler;
import net.minidev.json.JSONObject;

import static java.lang.Character.isDigit;

import java.util.LinkedList;

public class AdvanceJsonPath  {
    LinkedList<String> path;

    public static LinkedList<String> compile(String path){
        LinkedList<String> jp = new LinkedList<>();
        int currentIndex;
        try{
           PathCompiler.compile(path);
        }catch(InvalidPathException ex){
            String msg = ex.getMessage();
            if(msg.startsWith("Could not parse token starting at position ")){
              msg=   msg.replace("Could not parse token starting at position ","");
              currentIndex = getPosition(msg);
              jp.add(path.substring(0,currentIndex));
              if(path.substring(currentIndex).startsWith("[^(")){
                  String subpath = path.substring(currentIndex+3);
                  int backTraverseCount =  getPosition(subpath);

              }
            }
        }
        return null;
    }

    private static int getPosition(String msg){
        String no = "";
        for(char c : msg.toCharArray()){
            if(!isDigit(c)) {
                break;
            }
            no = no+c;
        }
        return Integer.parseInt(no);
    }

    public static void main(String[] args) {
      LinkedList<JPToken> path =  com.mjsoft.PathCompiler.compileJPToken("$.['xyz'].[4].['abc'].['abc'][?(@.aa === '')].[^(5)].['aaaa'].['qqqq']");
      System.out.println(path);
    }
}

/*
********************************************************************************
* システム：i-mode chat management				                               *
*==============================================================================*
* クラス　：ChatOutput             ｜モジュール：ChatOutput.java               *
* 概要　　：i-appli chat 発言出力クラス                                        *
* 作成　　：2004/06/01 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* 更新　　：																   *
********************************************************************************
*/

// パッケージのインポート
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import manage.system.*;
import manage.util.*;
import manage.talk.*;

/*-- クラス定義 --------------------------------------------------------------*/
public class ChatOutput extends HttpServlet {

  public void doGet(
    HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {


    	String w_data="";

		ChatLogRead _LogFileRead = new ChatLogRead();
		w_data = _LogFileRead.getLogData();

 
    // 返答データを"SJIS"に変換
    byte[] w_res = w_data.getBytes("SJIS");
    // 返答処理
    response.setContentType("application/octet-stream");
    response.setContentLength(w_res.length);
    OutputStream w_os = response.getOutputStream();
    w_os.write(w_res);
    w_os.close();

  }

}

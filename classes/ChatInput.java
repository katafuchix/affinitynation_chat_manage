/*
********************************************************************************
* システム：i-mode chat management				                               *
*==============================================================================*
* クラス　：ChatIntput             ｜モジュール：ChatInput.java                *
* 概要　　：i-appli chat 発言入力クラス                                        *
* 作成　　：2004/06/01 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* 更新　　：2004/06/03 K.Katafuchi(affinity)								   *
*			チャット参加フラグを受信データに追加 party						   *
********************************************************************************
*/

// パッケージのインポート
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import manage.system.*;
import manage.util.*;
import manage.talk.*;

/*-- クラス定義 --------------------------------------------------------------*/
public class ChatInput extends HttpServlet {
 public void doGet(
  HttpServletRequest request, HttpServletResponse response
 ) throws IOException, ServletException {

		JspRequestN jRqN = new JspRequestN(request);

		String _msg  = jRqN.getParameter("msg");
		
		String _party = _msg.substring(_msg.indexOf("&")+1, _msg.length());
			   _msg  =  _msg.substring(0,_msg.indexOf("&"));

//Static.Trace.out( _name + " : " + _party  );

		ChatLog _LogFile = new ChatLog();
		_LogFile.out( _msg );


	if( _party.equals("false")){

		String _name = "";
		       _name =  _msg.substring(0,_msg.indexOf(" > ") );

		DateTime dt = new DateTime();
		String time = dt.getString();

		ChatParticipation _JoinLog = new ChatParticipation();
		_JoinLog.out( _name + "=" + dt.getString( "HHmm" ) );

	}


	    response.setContentType("application/octet-stream");

		//書き込むだけなので余計な処理はしない

 }
}

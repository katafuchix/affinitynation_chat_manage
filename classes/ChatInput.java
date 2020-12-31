/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FChatIntput             �b���W���[���FChatInput.java                *
* �T�v�@�@�Fi-appli chat �������̓N���X                                        *
* �쐬�@�@�F2004/06/01 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F2004/06/03 K.Katafuchi(affinity)								   *
*			�`���b�g�Q���t���O����M�f�[�^�ɒǉ� party						   *
********************************************************************************
*/

// �p�b�P�[�W�̃C���|�[�g
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import manage.system.*;
import manage.util.*;
import manage.talk.*;

/*-- �N���X��` --------------------------------------------------------------*/
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

		//�������ނ����Ȃ̂ŗ]�v�ȏ����͂��Ȃ�

 }
}

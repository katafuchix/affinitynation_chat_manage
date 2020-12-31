/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FChatOutput             �b���W���[���FChatOutput.java               *
* �T�v�@�@�Fi-appli chat �����o�̓N���X                                        *
* �쐬�@�@�F2004/06/01 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F																   *
********************************************************************************
*/

// �p�b�P�[�W�̃C���|�[�g
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import manage.system.*;
import manage.util.*;
import manage.talk.*;

/*-- �N���X��` --------------------------------------------------------------*/
public class ChatOutput extends HttpServlet {

  public void doGet(
    HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {


    	String w_data="";

		ChatLogRead _LogFileRead = new ChatLogRead();
		w_data = _LogFileRead.getLogData();

 
    // �ԓ��f�[�^��"SJIS"�ɕϊ�
    byte[] w_res = w_data.getBytes("SJIS");
    // �ԓ�����
    response.setContentType("application/octet-stream");
    response.setContentLength(w_res.length);
    OutputStream w_os = response.getOutputStream();
    w_os.write(w_res);
    w_os.close();

  }

}

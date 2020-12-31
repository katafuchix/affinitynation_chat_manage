/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FSuper                   �b���W���[���FSuper.java                   *
* �T�v�@�@�F�ėp�X�[�p�[�N���X                                                 *
* �쐬�@�@�F2004/04/20 K.Katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F2004/05/28 K.Katafuchi(affinity)								   *
*			ai-land i-mode ���ڐA											   *
********************************************************************************
*/

/*-- �p�b�P�[�W --------------------------------------------------------------*/
package manage.util;

/*-- �C���|�[�g --------------------------------------------------------------*/
import  javax.servlet.jsp.*;
import  javax.servlet.http.*;
import  manage.system.*;

/*-- �N���X��` --------------------------------------------------------------*/
public class Super {

	static    String     Classname = "Super";

	protected JspWriter          out;
	protected JspRequest         request;
	protected HttpServletRequest req;

	  ////////////////////
	 // �R���X�g���N�^ //
	////////////////////
	public Super() {
	}

	  ///////////////////
	 // JspWriter�ݒ� //
	///////////////////
	public void setJspWriter( JspWriter jWriter ) {
		out = jWriter;
	}

	  ////////////////////
	 // JspRequest�ݒ� //
	////////////////////
	public void setJspRequest( HttpServletRequest Request ) {
		request = new JspRequest( Request );
	}

	  /////////////////
	 // Request�ݒ� //
	/////////////////
	public void setRequest( HttpServletRequest Request ) {
		req = Request;
	}

}

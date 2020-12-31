/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FStatic                  �b���W���[���FStatic.java                  *
* �T�v�@�@�F���O�o�͂Ȃ�                                                       *
* �쐬�@�@�F2004/04/16 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F2004/05/28 K.Katafuchi(affinity)								   *
*			ai-land i-mode ���ڐA											   *
********************************************************************************
*/

/*-- �p�b�P�[�W --------------------------------------------------------------*/
package manage.system;

/*-- �C���|�[�g --------------------------------------------------------------*/

/*-- �N���X��` --------------------------------------------------------------*/
public class Static {

	static        String  _MyName   = "Static";

	static public Property Property = new Property();
	static public String   HomeDir  = Property.getHomeDir();

	static public Log      Log      = new Log();
	static public ErrorLog Error    = new ErrorLog();
	static public Trace    Trace    = new Trace();

	static public Debug    Debug    = new Debug();

   	static public Trace    XXX     = new Trace( "XXX" );

	  ////////////////////
	 // �R���X�g���N�^ //
	////////////////////
	public Static() {
	}

}

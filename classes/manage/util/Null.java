/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FNull                    �b���W���[���FNull.java                    *
* �T�v�@�@�Fnull�֘A                                                           *
* �쐬�@�@�F2004/04/20 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F2004/05/28 K.Katafuchi(affinity)								   *
*			ai-land i-mode ���ڐA											   *
********************************************************************************
*/

/*-- �p�b�P�[�W --------------------------------------------------------------*/
package manage.util;

/*-- �C���|�[�g --------------------------------------------------------------*/
import  manage.util.*;

/*-- �N���X��` --------------------------------------------------------------*/
public class Null {

	static    String     Classname = "Null";

	  ////////////////////
	 // �R���X�g���N�^ //
	////////////////////
	public Null() {
	}

	  //////////////////////////////////
	 // null���f�t�H���g�l�ɒu������ //
	//////////////////////////////////
//	static public String replace( String Value, String Default ) {
//		return( replace( Value, Default ) );
//	}
	static public Object replace( Object Value, Object Default ) {
		Object Result = null;
		if( Value == null ) Result = Default;
		else                Result = Value;
		return( Result );
	}

};

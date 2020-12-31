/*
********************************************************************************
* �V�X�e���Fi-mode chat management				                               *
*==============================================================================*
* �N���X�@�FChatLogRead            �b���W���[���FChatLogRead.java              *
* �T�v�@�@�F�`���b�g���O�t�@�C���Ǘ��N���X                                     *
* �쐬�@�@�F2004/06/01 K.Katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* �X�V�@�@�F																   *
********************************************************************************
*/

/*-- �p�b�P�[�W --------------------------------------------------------------*/
package manage.talk;

/*-- �C���|�[�g --------------------------------------------------------------*/
import  java.io.*;
import  java.util.*;
import  javax.servlet.*;
import  javax.servlet.jsp.*;	
import  manage.system.*;
import  manage.util.*;

/*-- �N���X��` --------------------------------------------------------------*/
public class ChatLogRead {


	static		String     Classname = "ChatLogRead";
	static		String     _Encode;
	static		String	   _MaxLine;
	static		String	   _FileName;
	static		String 	   _LogData;
	static		String 	   _Directory; 
	static		boolean    _IsGetProperty = false;

	static		Hashtable _chat = new Hashtable();

	  ////////////////////
	 // �R���X�g���N�^ //
	////////////////////
	public ChatLogRead() {
		_initialize();
	}


	  ////////////
	 // ������ //
	////////////
	private void _initialize() {

		if( ! _IsGetProperty ) {
			Property P = new Property();
			P.open( Classname );
			_Encode    = P.getString( "Encode" );
			_MaxLine   = P.getString( "Line" );

			_IsGetProperty = true;
		}

		_LogData = "";
		_chat.clear();
	}


	  ////////////////////
	 // �G���R�[�h�ݒ� //
	////////////////////
	public void setEncode( String Encode ) {
		_Encode = Encode;
	}

	  //////////////////////
	 // �f�B���N�g���ݒ� //
	//////////////////////
	public void setDirectory( String Directory ) {
		_Directory = Directory;
	}

	  ////////////////////
	 // �t�@�C�����ݒ� //
	////////////////////
	public void setFilename( String Filename ) {
		_FileName = Filename;
	}


	  //////////
	 // �Ǐo //
	//////////
	public synchronized String getLogData() {
					
		ChatLog _LogFile = new ChatLog();
		if( _Directory == null ) _Directory = _LogFile.getDirectory();
		if( _FileName == null  ) _FileName  = _LogFile.getFilename();

		String LogNameFull = _Directory + _FileName;

			try {

				/* FileInputStream���g���ăt�@�C�����J�� */
				BufferedReader reader = new BufferedReader(new InputStreamReader( 
					 new FileInputStream( LogNameFull ), _Encode));

				/* �t�@�C���̓��e���P�s�Âǂ� */
				String line;
				int h = 0;
				int max = Integer.parseInt( _MaxLine );

				/* Hashtable�ɔ������i�[���čŐV�̂��̂���\���ł���悤�ɂ��� */

				while ((line=reader.readLine()) != null ) {

					_chat.put( Integer.toString(h), line );

					h++;
				}
								
				if( h < max ) max = h;
			
				for( int m=0; m<max ;m++ ){
					if(!_chat.get(Integer.toString(_chat.size()-1-m)).equals("") &&
						!_chat.get(Integer.toString(_chat.size()-1-m)).equals("null") ){

					_LogData += "\n" + _chat.get(Integer.toString(_chat.size()-1-m));
				
					}
				}

			}
			catch (Exception ex) {
				Static.Error.out( ex.toString() );
			}

				_chat.clear(); //�Z�b�V�����̒��Ŏc�邩������Ȃ��̂ŃN���A���Ă���

			if( _LogData == null ) _LogData = "";
			return _LogData;

	}


}
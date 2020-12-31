/*
********************************************************************************
* システム：i-mode chat management				                               *
*==============================================================================*
* クラス　：ChatLogRead            ｜モジュール：ChatLogRead.java              *
* 概要　　：チャットログファイル管理クラス                                     *
* 作成　　：2004/06/01 K.Katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* 更新　　：																   *
********************************************************************************
*/

/*-- パッケージ --------------------------------------------------------------*/
package manage.talk;

/*-- インポート --------------------------------------------------------------*/
import  java.io.*;
import  java.util.*;
import  javax.servlet.*;
import  javax.servlet.jsp.*;	
import  manage.system.*;
import  manage.util.*;

/*-- クラス定義 --------------------------------------------------------------*/
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
	 // コンストラクタ //
	////////////////////
	public ChatLogRead() {
		_initialize();
	}


	  ////////////
	 // 初期化 //
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
	 // エンコード設定 //
	////////////////////
	public void setEncode( String Encode ) {
		_Encode = Encode;
	}

	  //////////////////////
	 // ディレクトリ設定 //
	//////////////////////
	public void setDirectory( String Directory ) {
		_Directory = Directory;
	}

	  ////////////////////
	 // ファイル名設定 //
	////////////////////
	public void setFilename( String Filename ) {
		_FileName = Filename;
	}


	  //////////
	 // 読出 //
	//////////
	public synchronized String getLogData() {
					
		ChatLog _LogFile = new ChatLog();
		if( _Directory == null ) _Directory = _LogFile.getDirectory();
		if( _FileName == null  ) _FileName  = _LogFile.getFilename();

		String LogNameFull = _Directory + _FileName;

			try {

				/* FileInputStreamを使ってファイルを開く */
				BufferedReader reader = new BufferedReader(new InputStreamReader( 
					 new FileInputStream( LogNameFull ), _Encode));

				/* ファイルの内容を１行づつ読む */
				String line;
				int h = 0;
				int max = Integer.parseInt( _MaxLine );

				/* Hashtableに発言を格納して最新のものから表示できるようにする */

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

				_chat.clear(); //セッションの中で残るかもしれないのでクリアしておく

			if( _LogData == null ) _LogData = "";
			return _LogData;

	}


}
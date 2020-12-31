/*
********************************************************************************
* システム：i-mode chat management				                               *
*==============================================================================*
* クラス　：Static                  ｜モジュール：Static.java                  *
* 概要　　：ログ出力など                                                       *
* 作成　　：2004/04/16 K.katafuchi(affinity)                                   *
*------------------------------------------------------------------------------*
* 更新　　：2004/05/28 K.Katafuchi(affinity)								   *
*			ai-land i-mode より移植											   *
********************************************************************************
*/

/*-- パッケージ --------------------------------------------------------------*/
package manage.system;

/*-- インポート --------------------------------------------------------------*/

/*-- クラス定義 --------------------------------------------------------------*/
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
	 // コンストラクタ //
	////////////////////
	public Static() {
	}

}

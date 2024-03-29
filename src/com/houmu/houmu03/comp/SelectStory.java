package com.houmu.houmu03.comp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.app.AlertDialog;
import android.widget.Button;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;



public class SelectStory extends Activity implements OnClickListener{
	private StoreData sData;
	private Resources res01;
	private BufferedReader br;
	private StringTokenizer st;
	private String sectNo[];
	private String qNo[];
	private String category[];
	private String question[];
	private String answer[];
	private int answerNo[];
	private String strCSV[][];//csvファイルの内容を全部二次元の文字列行列に変換
	private String selection[][];
	private String explain[];
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		System.out.println("SELECT_STORY!!");
		super.onCreate(savedInstanceState);
		System.out.println("onCreate complete!");
		setContentView(R.layout.select_story);
		
		int readingRowCount = 50;
		sectNo = new String[readingRowCount];
		qNo = new String[readingRowCount];
		category = new String[qNo.length];
		question = new String[qNo.length];
		answer = new String[qNo.length];
		answerNo = new int[qNo.length];
		
		selection = new String[qNo.length][5];//選択肢の個数は5個
		explain = new String[qNo.length];
		
		res01 = this.getResources();
		System.out.println("selectStory内格納完了");
		
	}
	public void onClick(View v){
		/* ImageButtonを使った場合、
		 * viewを一度ButtonにキャストしてしまうとImageButtonに直せないので
		 * 　　　　下のImageButtonの判定に使えない！！
		 */
		
		System.out.println("original view = " + v.toString());
		
		/*
		View viewImageButton = v;
		View viewButton = v;
		//viewがButtonオブジェクトである場合、以下の格納をする際にエラーが発生
		viewImageButton = (ImageButton)viewImageButton;
		viewButton = (Button)viewButton;
		System.out.println("１original view = " + v.toString());
		System.out.println("１image button = " + viewImageButton.toString());
		System.out.println("１button = " + viewButton.toString());
	 	*/
		
		
		//以下判定(try-errorで捉えても良い）
		//参考：substring(start, end)は文字列を０からカウントして[start]番目から[end-1]番目までを抽出
		System.out.println(((v.toString())).substring(0,21));
		System.out.println("button pressed");
		if(((Button)v).getId() == R.id.s_s_bt_return){

			System.out.println("pressed finish button!");
			finish();
			return;
		}else if(((Button)v).getId()==R.id.s_st_bt_Q1){
			System.out.println("pressed story1");
			InputStream is = res01.openRawResource(R.raw.homu1);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q2){
			System.out.println("pressed story2");
			InputStream is = res01.openRawResource(R.raw.homu2);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q3){
			System.out.println("pressed story3");
			InputStream is = res01.openRawResource(R.raw.homu3);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q4){
			System.out.println("pressed story4");
			InputStream is = res01.openRawResource(R.raw.homu4);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q5){
			System.out.println("pressed story5");
			InputStream is = res01.openRawResource(R.raw.homu5);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q6){
			System.out.println("pressed story6");
			InputStream is = res01.openRawResource(R.raw.homu6);
			if (setQSA2(is)){//ファイルの読み込みに成功したらStoreDataオブジェクトのフィールドにcsv情報が格納される。
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sDataはsetQSA内で格納されている
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//ダイアログで閉じる
			}
			return;
			
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }    
    
	public boolean setQSA2(InputStream is){
		/**
		 * 以下の三項目をStoreData(グローバル)インスタンスに格納
		 * Question
		 * Selection
		 * Answer
		 */
		//出力用問題文格納配列
		String[] outputQuestion = null;
		
		//InputStream is = res01.openRawResource(R.raw.eigo001);
		br = new BufferedReader(new InputStreamReader(is));
		
		//strCSV配列(二次元)に格納
		strCSV = new String[50][21];//50x20次元マトリクス
		
		try{
			for(int row = 0;row<strCSV.length;row++){
				//一行読み込んでトークンに分解
				StringTokenizer st = new StringTokenizer(br.readLine(), ",");
				for(int col =0;col < strCSV[row].length;col++){
					//strCsvの各要素に格納
					strCSV[row][col] = st.nextToken();
					System.out.println("strCSV[" + row + "][" + col + "] = " + strCSV[row][col]);
					if(!st.hasMoreTokens()){
						break;//for col
					}
				}
				if(strCSV[row][0].equals("[EOF]")){
					//再終業に達したらcsv読み込み終了
					break;//for row
				}
			}
			System.out.println("all CSV-word is completed reading!!");
			/*
			for(int row = 0;row < strCSV.length;row ++){
				for(int col = 0; col<strCSV[row].length;col ++){
					System.out.print(strCSV[row][col] + ",");
				}
				System.out.println("\n");
			}
			*/
			
		}catch(Exception e){
			System.out.println("CSV読み込み時にエラー発生！！");
			System.out.println("エラーは" + e);
		}
		
		int rowCSV = 1;//読込用カウンター(0行目はラベル)
		int noArray = 0;//格納用カウンター
		
		
		do{//カウンターrowCSVでループ
			System.out.println("rowCSV =  " + rowCSV);
			if(strCSV[rowCSV][1] == null){
				/*
				 * strCSV配列の最後まで読み込んだとき 
				 */
				//strCSVを格納する時に[EOF]の行はゼロ列目が[EOF]で１列目以降はnull
				System.out.println(rowCSV + "行目の一列目がNullですので最後まで配列に格納し終わりました。");
				break;
			}else{
				//デバッグの必要
				System.out.println("strCSV = " + strCSV[rowCSV][1]);
			}
			//現在の行の問題文がハイフンであるならば次の行を読み込む
			if((!strCSV[rowCSV][3].equals("-"))){
				/*
				 * 章番号の格納
				 */
				sectNo[noArray] = strCSV[rowCSV][0];
				
				/*
				 * カテゴリの格納
				 */
				category[noArray] = strCSV[rowCSV][2];//カテゴリー
				/*
				 *問題番号の格納 
				 */
				qNo[noArray] = strCSV[rowCSV][1];
				//category = strCSV[rowCSV][2];←ループ内で格納する必要がないので外出し済
				/*
				 * 質問文の格納(D列)
				 */
				question[noArray] = strCSV[rowCSV][3];
				System.out.println("noArray = " + noArray);
				System.out.println("question = " + question[noArray]);
				
				
				//選択肢語句の設定(格納場所はE列からH列)
				for(int slcNo = 0;slcNo < selection[noArray].length;slcNo++){
					int colCSV = slcNo + 4;//選択肢の格納場所は４列目から始まる
					selection[noArray][slcNo] = strCSV[rowCSV][colCSV];
					System.out.println("selection:" + slcNo + "=" + selection[noArray][slcNo]);
				}
				
				//解答番号格納
				answerNo[noArray] = Integer.parseInt(strCSV[rowCSV][9]);
				
				//解答格納
				answer[noArray] = strCSV[rowCSV][10];
				
				/*
				 * 解説文の取り込み
				 */
				explain[noArray] = strCSV[rowCSV][11];//現状解説はなしとする→問題番号を格納しておく
				System.out.println("explain complete initiating");
				
				noArray++;
				
			}else if(strCSV[rowCSV][0].equals("[EOF]")){
				//常に次の行の一列目に[EOF]があるか確認しているため不必要な処理？
				System.out.println("ここに制御フローが流れることはない");
				
				break;
			}
			rowCSV ++;
		}while(true);
		//選択肢selectionは5列目から9列目(col=4-8)を読み込んで格納
		
		
		//問題の最後に達したら、問題格納配列questionの要素数を当該問題番号rowまでoutputQuestionにする
		outputQuestion = new String[rowCSV-1];
		System.arraycopy(question, 0, outputQuestion, 0, outputQuestion.length);
		
		for(int no = 0;no<outputQuestion.length;no++){
			System.out.println(no + ","  + outputQuestion[no]);
		}
		
		System.out.println("complete initiating Array!!");
		
		sData = new StoreData();
		System.out.println("complete initiating StoreData!!");
		//問題の章番号はSECTを除いた数値部分のみ渡す
		System.out.println(sectNo[0].replaceAll("SECT", ""));
		sData.setSectNo(Integer.valueOf(sectNo[0].replaceAll("SECT","")).intValue());
		System.out.println(Integer.valueOf(sectNo[0].replaceAll("SECT", "")).intValue());
		System.out.println("complete setSectNo");
		sData.setCategory(category);
		System.out.println("complete setCategory");
		sData.setQuestion(outputQuestion);
		System.out.println("complete setQuestion");
		sData.setSelection(selection);
		System.out.println("complete setSelection");
		sData.setAnswer(answer);
		System.out.println("complete answer");
		sData.setAnswerNo(answerNo);
		System.out.println("complete answerNo");
		sData.setExplain(explain);
		System.out.println("complete setExplain");
		
	
		return true;
	}
	public void dispAlert(){
		//まだライト版はダイアログを表示して終了する
		new AlertDialog.Builder(this)
			.setMessage("誠に申し訳ございませんが、完全版のみのご利用となります。")
			.setCancelable(true)
			.setPositiveButton("閉じる", 
					new  DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){
							return;
						}
			})
		.show();
	}

}

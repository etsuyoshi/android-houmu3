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
	private String strCSV[][];//csv�t�@�C���̓��e��S���񎟌��̕�����s��ɕϊ�
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
		
		selection = new String[qNo.length][5];//�I�����̌���5��
		explain = new String[qNo.length];
		
		res01 = this.getResources();
		System.out.println("selectStory���i�[����");
		
	}
	public void onClick(View v){
		/* ImageButton���g�����ꍇ�A
		 * view����xButton�ɃL���X�g���Ă��܂���ImageButton�ɒ����Ȃ��̂�
		 * �@�@�@�@����ImageButton�̔���Ɏg���Ȃ��I�I
		 */
		
		System.out.println("original view = " + v.toString());
		
		/*
		View viewImageButton = v;
		View viewButton = v;
		//view��Button�I�u�W�F�N�g�ł���ꍇ�A�ȉ��̊i�[������ۂɃG���[������
		viewImageButton = (ImageButton)viewImageButton;
		viewButton = (Button)viewButton;
		System.out.println("�Poriginal view = " + v.toString());
		System.out.println("�Pimage button = " + viewImageButton.toString());
		System.out.println("�Pbutton = " + viewButton.toString());
	 	*/
		
		
		//�ȉ�����(try-error�ő����Ă��ǂ��j
		//�Q�l�Fsubstring(start, end)�͕�������O����J�E���g����[start]�Ԗڂ���[end-1]�Ԗڂ܂ł𒊏o
		System.out.println(((v.toString())).substring(0,21));
		System.out.println("button pressed");
		if(((Button)v).getId() == R.id.s_s_bt_return){

			System.out.println("pressed finish button!");
			finish();
			return;
		}else if(((Button)v).getId()==R.id.s_st_bt_Q1){
			System.out.println("pressed story1");
			InputStream is = res01.openRawResource(R.raw.homu1);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q2){
			System.out.println("pressed story2");
			InputStream is = res01.openRawResource(R.raw.homu2);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q3){
			System.out.println("pressed story3");
			InputStream is = res01.openRawResource(R.raw.homu3);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q4){
			System.out.println("pressed story4");
			InputStream is = res01.openRawResource(R.raw.homu4);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
				
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q5){
			System.out.println("pressed story5");
			InputStream is = res01.openRawResource(R.raw.homu5);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
			}
			return;
			
		}else if(((Button)v).getId()==R.id.s_st_bt_Q6){
			System.out.println("pressed story6");
			InputStream is = res01.openRawResource(R.raw.homu6);
			if (setQSA2(is)){//�t�@�C���̓ǂݍ��݂ɐ���������StoreData�I�u�W�F�N�g�̃t�B�[���h��csv��񂪊i�[�����B
				System.out.println("reading csv file succeed!!");
				Intent intent=new Intent(SelectStory.this, WordModel0.class);
				System.out.println("complete initiating intent");
				intent.putExtra("StoreData", sData);//sData��setQSA���Ŋi�[����Ă���
				System.out.println("complete initiating putExtra");
				intent.setAction(Intent.ACTION_VIEW);
				System.out.println("complete initiating setAction");
				startActivity(intent);
				System.out.println("complete initiating startActivity");
			}else{
				System.out.println("reading csv file failed!!");
				//�_�C�A���O�ŕ���
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
		 * �ȉ��̎O���ڂ�StoreData(�O���[�o��)�C���X�^���X�Ɋi�[
		 * Question
		 * Selection
		 * Answer
		 */
		//�o�͗p��蕶�i�[�z��
		String[] outputQuestion = null;
		
		//InputStream is = res01.openRawResource(R.raw.eigo001);
		br = new BufferedReader(new InputStreamReader(is));
		
		//strCSV�z��(�񎟌�)�Ɋi�[
		strCSV = new String[50][21];//50x20�����}�g���N�X
		
		try{
			for(int row = 0;row<strCSV.length;row++){
				//��s�ǂݍ���Ńg�[�N���ɕ���
				StringTokenizer st = new StringTokenizer(br.readLine(), ",");
				for(int col =0;col < strCSV[row].length;col++){
					//strCsv�̊e�v�f�Ɋi�[
					strCSV[row][col] = st.nextToken();
					System.out.println("strCSV[" + row + "][" + col + "] = " + strCSV[row][col]);
					if(!st.hasMoreTokens()){
						break;//for col
					}
				}
				if(strCSV[row][0].equals("[EOF]")){
					//�ďI�ƂɒB������csv�ǂݍ��ݏI��
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
			System.out.println("CSV�ǂݍ��ݎ��ɃG���[�����I�I");
			System.out.println("�G���[��" + e);
		}
		
		int rowCSV = 1;//�Ǎ��p�J�E���^�[(0�s�ڂ̓��x��)
		int noArray = 0;//�i�[�p�J�E���^�[
		
		
		do{//�J�E���^�[rowCSV�Ń��[�v
			System.out.println("rowCSV =  " + rowCSV);
			if(strCSV[rowCSV][1] == null){
				/*
				 * strCSV�z��̍Ō�܂œǂݍ��񂾂Ƃ� 
				 */
				//strCSV���i�[���鎞��[EOF]�̍s�̓[����ڂ�[EOF]�łP��ڈȍ~��null
				System.out.println(rowCSV + "�s�ڂ̈��ڂ�Null�ł��̂ōŌ�܂Ŕz��Ɋi�[���I���܂����B");
				break;
			}else{
				//�f�o�b�O�̕K�v
				System.out.println("strCSV = " + strCSV[rowCSV][1]);
			}
			//���݂̍s�̖�蕶���n�C�t���ł���Ȃ�Ύ��̍s��ǂݍ���
			if((!strCSV[rowCSV][3].equals("-"))){
				/*
				 * �͔ԍ��̊i�[
				 */
				sectNo[noArray] = strCSV[rowCSV][0];
				
				/*
				 * �J�e�S���̊i�[
				 */
				category[noArray] = strCSV[rowCSV][2];//�J�e�S���[
				/*
				 *���ԍ��̊i�[ 
				 */
				qNo[noArray] = strCSV[rowCSV][1];
				//category = strCSV[rowCSV][2];�����[�v���Ŋi�[����K�v���Ȃ��̂ŊO�o����
				/*
				 * ���╶�̊i�[(D��)
				 */
				question[noArray] = strCSV[rowCSV][3];
				System.out.println("noArray = " + noArray);
				System.out.println("question = " + question[noArray]);
				
				
				//�I�������̐ݒ�(�i�[�ꏊ��E�񂩂�H��)
				for(int slcNo = 0;slcNo < selection[noArray].length;slcNo++){
					int colCSV = slcNo + 4;//�I�����̊i�[�ꏊ�͂S��ڂ���n�܂�
					selection[noArray][slcNo] = strCSV[rowCSV][colCSV];
					System.out.println("selection:" + slcNo + "=" + selection[noArray][slcNo]);
				}
				
				//�𓚔ԍ��i�[
				answerNo[noArray] = Integer.parseInt(strCSV[rowCSV][9]);
				
				//�𓚊i�[
				answer[noArray] = strCSV[rowCSV][10];
				
				/*
				 * ������̎�荞��
				 */
				explain[noArray] = strCSV[rowCSV][11];//�������͂Ȃ��Ƃ��遨���ԍ����i�[���Ă���
				System.out.println("explain complete initiating");
				
				noArray++;
				
			}else if(strCSV[rowCSV][0].equals("[EOF]")){
				//��Ɏ��̍s�̈��ڂ�[EOF]�����邩�m�F���Ă��邽�ߕs�K�v�ȏ����H
				System.out.println("�����ɐ���t���[������邱�Ƃ͂Ȃ�");
				
				break;
			}
			rowCSV ++;
		}while(true);
		//�I����selection��5��ڂ���9���(col=4-8)��ǂݍ���Ŋi�[
		
		
		//���̍Ō�ɒB������A���i�[�z��question�̗v�f���𓖊Y���ԍ�row�܂�outputQuestion�ɂ���
		outputQuestion = new String[rowCSV-1];
		System.arraycopy(question, 0, outputQuestion, 0, outputQuestion.length);
		
		for(int no = 0;no<outputQuestion.length;no++){
			System.out.println(no + ","  + outputQuestion[no]);
		}
		
		System.out.println("complete initiating Array!!");
		
		sData = new StoreData();
		System.out.println("complete initiating StoreData!!");
		//���͔̏ԍ���SECT�����������l�����̂ݓn��
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
		//�܂����C�g�ł̓_�C�A���O��\�����ďI������
		new AlertDialog.Builder(this)
			.setMessage("���ɐ\���󂲂����܂��񂪁A���S�ł݂̂̂����p�ƂȂ�܂��B")
			.setCancelable(true)
			.setPositiveButton("����", 
					new  DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){
							return;
						}
			})
		.show();
	}

}

package com.lanchuang.wgc.android_wgcwgc_intent;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// ��ָ����ҳ
	public void browsePageClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.cnblogs.com/jeff-wgc/"));
		startActivity(intent);

	}

	// �򿪲������
	public void openDialPageClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:17082209943"));
		startActivity(intent);
	}

	// ֱ�Ӳ���ָ������
	public void dialPhoneClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:13938946534"));
		startActivity(intent);
	}

	// �򿪷����ŵĽ���:action+type
	public void openMsgPageClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setType("vnd.android-dir/mms-sms");
		intent.putExtra("sms_body" ,"�Ǹ�"); // "sms_body"Ϊ�̶�����
		startActivity(intent);
	}

	// �򿪷����ŵĽ���(ָ���绰����):action+data
	public void sendMsgClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setData(Uri.parse("smsto:10010"));
		intent.putExtra("sms_body" ,"0000"); // "sms_body"Ϊ�̶�����
		startActivity(intent);
	}

	// ����ָ��·������
	public void playMusicClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri uri = Uri.parse("file:///mnt/sdcard/netease/cloudmusic/Music/����γ - ���.mp3"); // ·��Ҳ����д�ɣ�"/storage/sdcard0/ƽ��֮·.mp3"
		intent.setDataAndType(uri ,"audio/mp3"); // ������Intent
		                                         // android.content.Intent.setDataAndType(Uri
		                                         // data, String type)
		startActivity(intent);
	}

	// ж��ĳ��Ӧ�ó��򣬸��ݰ�����ʶ��
	public void uninstallClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_DELETE);
		Uri data = Uri.parse("package:com.lanchuang.wgc.android_wgcwgc_ui");
		intent.setData(data);
		startActivity(intent);
	}

	// ��װĳ��Ӧ�ó��򣬸���apk���ļ�����ʶ��
	@SuppressLint("SdCardPath")
	public void installClick(View view )
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri data = Uri.fromFile(new File("/mnt/sdcard/360/app/Android_Wgcwgc_UI.apk"));
		// ·������д�ɣ�"file:///storage/sdcard0/������"
		intent.setDataAndType(data ,"application/vnd.android.package-archive"); // Type���ַ���Ϊ�̶�����
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main ,menu);
		return true;
	}
}

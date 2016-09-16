package com.example.prayas;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class camera extends Activity {

    private Camera myCamera;
    static final int REQUEST_VIDEO_CAPTURE = 12;
    ProgressDialog pdia;
    String selectedPath="";
    String filename;
    Button myButton,upload;
    ImageView myCameraPreview ;

    String tempPath;
    public static String path1;

    private static final int SELECT_FILE = 100;
    File file;

    HttpURLConnection connection = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    String urlServer = "http://192.168.1.108/WebSite3/Default.aspx";
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";

    int bytesRead, bytesAvailable, bufferSize;
    byte[] buffer;
    int maxBufferSize = 1*1024*1024;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.uploadvideo);

        //Get Camera for preview


        myCameraPreview = (ImageView)findViewById(R.id.imageView);


        myButton = (Button)findViewById(R.id.button);
        upload =(Button) findViewById(R.id.birdeye);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(camera.this, "selected", Toast.LENGTH_LONG).show();
            	selectImage();
            Toast.makeText(camera.this, path1, Toast.LENGTH_LONG).show();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void selectImage()
    {
        final CharSequence[] items = { "Take Photo", "Choose from Library","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(camera.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    path1=f.getName();
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            if (requestCode == 1)
            {

                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles())
                {
                    if (temp.getName().equals("temp.jpg"))
                    {
                        f = temp;
                        break;
                    }
                }
                try
                {
                    Bitmap bm;
                    BitmapFactory.Options btmapOptions = new BitmapFactory.Options();
                    bm = BitmapFactory.decodeFile(f.getAbsolutePath(),btmapOptions);

                    Toast.makeText(camera.this, "uploading.....", Toast.LENGTH_LONG).show();
                    new uploadtask(f.getAbsolutePath()).execute();
                 //   doFileUpload(f.getAbsolutePath());

                    myCameraPreview.setImageBitmap(bm);

        /*            String path = android.os.Environment.getExternalStorageDirectory() + File.separator + "Phoenix" + File.separator + "default";

                    f.delete();
                    OutputStream fOut = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");

                    fOut = new FileOutputStream(file);
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
*/
                }
                catch (Exception e)
                {
                    Toast.makeText(camera.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Uri selectedImageUri = data.getData();

                tempPath = getPath(selectedImageUri, camera.this);
                Bitmap bm;
                BitmapFactory.Options btmapOptions = new BitmapFactory.Options();
                bm = BitmapFactory.decodeFile(tempPath, btmapOptions);
                myCameraPreview.setImageBitmap(bm);
                Log.d("path", tempPath);
                //prepareTouploadImage(tempPath);
                new uploadtask(tempPath).execute();

                Toast.makeText(camera.this, tempPath,Toast.LENGTH_LONG).show();
            }
        }
    }

    public String getPath(Uri uri, Activity activity) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = activity
                .managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }

    private class uploadtask extends AsyncTask<String, Void, String> {

        String name1;
        uploadtask(String name)
        {
            name1=name;

        }
        @Override
        protected String doInBackground(String... params) {

            doFileUpload(name1);
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {}


    }
    private void doFileUpload(String fpath)
    {
        try
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(new File(fpath) );

                URL url = new URL(urlServer);
                connection = (HttpURLConnection) url.openConnection();

                // Allow Inputs &amp; Outputs.
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setUseCaches(false);

                // Set HTTP method to POST.
                connection.setRequestMethod("POST");

                Log.d("yes", "1");
                connection.setRequestProperty("Connection", "Keep-Alive");
                connection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);

                outputStream = new DataOutputStream( connection.getOutputStream() );
                outputStream.writeBytes(twoHyphens + boundary + lineEnd);
                outputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + fpath +"\"" + lineEnd);
                outputStream.writeBytes(lineEnd);

                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];
                Log.d("yes", "2");
                // Read file
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                while (bytesRead > 0)
                {
                    outputStream.write(buffer, 0, bufferSize);
                    bytesAvailable = fileInputStream.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                }

                outputStream.writeBytes(lineEnd);
                outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                // Responses from the server (code and message)
                int serverResponseCode = connection.getResponseCode();
                String serverResponseMessage = connection.getResponseMessage();

                fileInputStream.close();
                outputStream.flush();
                outputStream.close();
            }
            catch (Exception ex)
            {
            Log.d("error", ex.toString());
            	ex.printStackTrace();
                //Exception handling
            }

        }
        catch(Exception e)
        {
        	Log.d("error", e.toString());
            e.printStackTrace();
        }

    }


}
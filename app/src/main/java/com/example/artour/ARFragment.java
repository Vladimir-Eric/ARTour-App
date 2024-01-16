package com.example.artour;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.model.Model;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ARFragment extends Fragment implements View.OnClickListener {


   private static final String TAG = ARFragment.class.getSimpleName();

    // Add other variables from MainActivity here
    private static final int PERMISSION_STATE = 0;
    private static final int CAMERA_REQUEST = 1;
    private Button imgCamera;
    private ImageView imgResult;
    private Button btnPredict;
    private TextView txtPrediction;
    private Bitmap bitmap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_r, container, false);

        // Initialize your views and buttons here
        imgCamera = view.findViewById(R.id.captureButton); // Zamenite sa vašim stvarnim ID-om dugmeta
        imgResult = view.findViewById(R.id.resultImage); // Zamenite sa vašim ID-om ImageView-a
        btnPredict = view.findViewById(R.id.scanButton); // Zamenite sa vašim ID-om dugmeta
        txtPrediction = view.findViewById(R.id.textViewPrediction); // Zamenite sa vašim ID-om TextView-a

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scanButton) {
            predict();
        } else if (view.getId() == R.id.captureButton) {
            launchCamera();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
        btnPredict.setOnClickListener(this::onClick);
        imgCamera.setOnClickListener(this::onClick);
        checkPermissions();
        btnPredict.setOnClickListener(this);
        imgCamera.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
        btnPredict.setOnClickListener(null);
        imgCamera.setOnClickListener(null);
    }

    private void launchCamera() { Log.d(TAG,"launchCamera()");
        startActivityForResult(new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE), CAMERA_REQUEST);
    }



    public void predict() {
        Log.d(TAG, "predict()");
        bitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true);
        try {
            // Učitajte model koristeći Interpreter
            Interpreter interpreter = new Interpreter(loadModelFile(requireContext(), "your_model.tflite"));

            // Kreirajte ulazni TensorBuffer i postavite ulazne podatke
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.UINT8);
            TensorImage tensorImage = new TensorImage(DataType.UINT8);
            tensorImage.load(bitmap);
            ByteBuffer byteBuffer = tensorImage.getBuffer();
            inputFeature0.loadBuffer(byteBuffer);

            // Definišite izlazne tensorBuffer-e
            TensorBuffer outputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 7}, DataType.FLOAT32);

            // Pokrenite model inferenciju
            interpreter.run(inputFeature0.getBuffer(), outputFeature0.getBuffer().rewind());

            // Oslobodite resurse
            interpreter.close();

            // Prikazivanje rezultata
            txtPrediction.setText(getMax(outputFeature0.getFloatArray()));
            Log.d("Result", Arrays.toString(outputFeature0.getFloatArray()));
        } catch (IOException e) {
            Log.e(TAG, "IOException " + e.getMessage());
        }
    }

    // Funkcija za učitavanje modela iz resursa
    private MappedByteBuffer loadModelFile(Context context, String modelFileName) throws IOException {
        AssetFileDescriptor fileDescriptor = context.getAssets().openFd(modelFileName);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }


    private String getMax(float [] outputs) { Log.d(TAG,"getMax( " + Arrays.toString(outputs) + ")");
        if (outputs.length != 0 & outputs[0] > outputs[1] & outputs[0] > outputs[2] & outputs[0] > outputs[3]) {
            return "BARBODES";
        } else if (outputs.length != 0 & outputs[1] > outputs[0] & outputs[1] > outputs[2] & outputs[1] > outputs[3]) {
            return "CAT FISH";
        } else if (outputs.length != 0 & outputs[2] > outputs[0] & outputs[2] > outputs[1] & outputs[2] > outputs[3]) {
            return "GALUNGGONG";
        }else if (outputs.length != 0 & outputs[3] > outputs[0] & outputs[3] > outputs[1]  & outputs[3] > outputs[2]) {
            return "NAPOLEON WRASSE";
        } else {
            return "";
        }
    }

    private void checkPermissions() {
        String[] manifestPermissions;
        manifestPermissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        for (String permission : manifestPermissions) {
            if (ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission Granted " + permission);
            }
            if (ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_DENIED) {
                Log.d(TAG, "Permission Denied " + permission);
                requestPermissions();
            }
        }
    }

    private void requestPermissions() { Log.d(TAG, "requestPermissions()");
        String[] manifestPermissions;
        manifestPermissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ActivityCompat.requestPermissions(
                getActivity(),
                manifestPermissions,
                PERMISSION_STATE
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "PermissionsResult requestCode " + requestCode);
        Log.d(TAG, "PermissionsResult permissions " + Arrays.toString(permissions));
        Log.d(TAG, "PermissionsResult grantResults " + Arrays.toString(grantResults));
        if (requestCode == PERMISSION_STATE) {
            for (int grantResult : grantResults) {
                switch (grantResult) {
                    case PackageManager.PERMISSION_GRANTED:
                        Log.d(TAG, "PermissionsResult grantResult Allowed " + grantResult);
                        break;
                    case PackageManager.PERMISSION_DENIED:
                        Log.d(TAG, "PermissionsResult grantResult Denied " + grantResult);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult requestCode " + requestCode + " resultCode" + resultCode + "data " + data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imgResult.setImageBitmap(bitmap);
        }
    }

}
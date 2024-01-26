package com.example.artour;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.artour.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

public class ARFragment extends Fragment {

    TextView result, confidence;
    ImageView imageView;
    Button picture;
    int imageSize = 224;
    Model model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_r, container, false);

        result = view.findViewById(R.id.result);
        confidence = view.findViewById(R.id.confidence);
        imageView = view.findViewById(R.id.menu_heading);
        picture = view.findViewById(R.id.button);

        picture.setOnClickListener(view1 -> {
            // Provjera dozvola za kameru
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                // Pokretanje kamere ako imamo dozvolu
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);
            } else {
                // Zahtjevanje dozvole za kameru ako nemamo
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, 100);
            }
        });
        return view;
    }

    @SuppressLint("DefaultLocale")
    public void classifyImage(Bitmap image){
        LinearLayout naslovLayout = requireView().findViewById(R.id.tekst);
        naslovLayout.setVisibility(View.GONE);

        TextView upit1 = requireView().findViewById(R.id.upit_text);
        upit1.setVisibility(View.GONE);

        TextView upit2 = requireView().findViewById(R.id.upit_text2);
        upit2.setVisibility(View.GONE);

        TextView resultTextView = requireView().findViewById(R.id.result);
        resultTextView.setVisibility(View.VISIBLE);

        TextView confidencesText = requireView().findViewById(R.id.confidencesText);
        confidencesText.setVisibility(View.VISIBLE);

        TextView classifiedTextView = requireView().findViewById(R.id.classified);
        classifiedTextView.setVisibility(View.VISIBLE);

        try {
            model = Model.newInstance(requireContext());
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            for (int i = 0; i < imageSize; i++) {
                for (int j = 0; j < imageSize; j++) {
                    int val = intValues[pixel++];
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat(((val & 0xFF)) * (1.f / 255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            displayResult(maxPos, confidences);

        } catch (IOException e) {
            //
        } finally {
            if (model != null) {
                model.close();
            }
        }
    }

    private void displayResult(int maxPos, float[] ignoredConfidences) {
        String[] classes = {"Bager", "Buldozer", "Bušilica", "Damper", "Rudarska lokomotiva", "Utovarivač", "Rajkov toranj"};

        int[] imageResources = {R.drawable.muzej, R.drawable.buldozer, R.drawable.busilica, R.drawable.damper, R.drawable.rudarska_lokomotiva, R.drawable.utovarivac, R.drawable.toranj_prikaz};

        //Postavljanje teksta i slike date masine
        if(maxPos == 0){
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.bager));
        } else if (maxPos == 1) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.buldozer));
        } else if (maxPos == 2) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.busilica));
        }else if (maxPos == 3) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.damper));
        }else if (maxPos == 4) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.rudarska_lokomotiva));
        }else if (maxPos == 5) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.utovarivac));
        }else if (maxPos == 6) {
            result.setText(classes[maxPos]);
            imageView.setImageResource(imageResources[maxPos]);
            confidence.setText(getString(R.string.rajkov_toranj));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Bitmap image = (Bitmap) Objects.requireNonNull(Objects.requireNonNull(data).getExtras()).get("data");
            int dimension = Math.min(Objects.requireNonNull(image).getWidth(), image.getHeight());
            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
            imageView.setImageBitmap(image);

            image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
            classifyImage(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
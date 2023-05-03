package com.firstapp.chordappver8_onechordrandomprogressions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner keySpinner;
    private Button randomizeButton;
    private TextView chordProgressionTextView;

    /**
     * Returns an array of chord progressions for the specified key.
     *
     * Pre-conditions:
     * - key is a non-null string representing a valid musical key (C, C#, D, etc.)
     *
     * Post-conditions:
     * - Returns a non-null 2D array of strings, where each sub-array represents a valid chord progression
     *   for the specified key.
     */
    private String[][] getChordProgressions(String key) {
        String[][] chordProgressions;
        switch (key) {
            case "C":
                chordProgressions = new String[][]{
                        {"C", "F", "G"},
                        {"C", "G", "Am", "F"},
                        {"Am", "F", "C", "G"},
                        {"C", "F", "Am", "G"},
                        {"Am", "F", "G"},
                        {"C", "G", "F", "G"},
                        {"C", "Am", "F", "G"},
                        {"C", "F", "Am", "Em", "G", "F"},
                        {"C", "F", "G", "C"},
                        {"C", "G", "Am", "Em", "F", "C", "G"},
                        {"C", "Am", "F", "G", "C", "Am", "F", "G"},
                        {"C", "G", "Am", "F", "C", "G", "F", "C"}
                };
                break;
            case "C#":
                chordProgressions = new String[][]{
                        {"C#", "F#", "G#"},
                        {"C#", "G#", "A#m", "F#"},
                        {"A#m", "F#", "C#", "G#"},
                        {"C#", "F#", "A#m", "G#"},
                        {"A#m", "F#", "G#"},
                        {"C#", "G#", "F#", "G#"},
                        {"C#", "A#m", "F#", "G#"},
                        {"C#", "F#", "A#m", "Fm", "G#", "F#"},
                        {"D#m", "G#", "C#"},
                        {"C#", "F#", "C#", "G#", "F#", "C#"}
                };
                break;
            case "D":
                chordProgressions = new String[][]{
                        {"D", "G", "A"},
                        {"D", "A", "Bm", "G"},
                        {"Bm", "G", "D", "A"},
                        {"D", "G", "Bm", "A"},
                        {"Bm", "G", "A"},
                        {"D", "A", "G", "A"},
                        {"D", "Bm", "G", "A"},
                        {"D", "G", "Bm", "F#m", "A", "G"},
                        {"Em", "A", "D"},
                        {"D", "G", "D", "A", "G", "D"}
                };
                break;
            case "D#":
                chordProgressions = new String[][]{
                        {"D#", "G#", "A#"},
                        {"D#", "A#", "Cm", "G#"},
                        {"Cm", "G#", "D#", "A#"},
                        {"D#", "G#", "Cm", "A#"},
                        {"Cm", "G#", "A#"},
                        {"D#", "A#", "G#", "A#"},
                        {"D#", "Cm", "G#", "A#"},
                        {"D#", "G#", "Cm", "Bm", "A#", "G#"},
                        {"Fm", "A#", "D#"},
                        {"D#", "G#", "D#", "A#", "G#", "D#"}
                };
                break;
            case "E":
                chordProgressions = new String[][]{
                        {"E", "A", "B"},
                        {"E", "B", "C#m", "A"},
                        {"C#m", "A", "E", "B"},
                        {"E", "A", "C#m", "B"},
                        {"C#m", "A", "B"},
                        {"E", "B", "A", "B"},
                        {"E", "C#m", "A", "B"},
                        {"E", "A", "C#m", "G#m", "B", "A"},
                        {"F#m", "B", "E"},
                        {"E", "A", "E", "B", "A", "E"}
                };
                break;
            case "F":
                chordProgressions = new String[][]{
                        {"F", "Bb", "C"},
                        {"F", "C", "Dm", "Bb"},
                        {"Dm", "Bb", "F", "C"},
                        {"F", "Bb", "Dm", "C"},
                        {"Dm", "Bb", "C"},
                        {"F", "C", "Bb", "C"},
                        {"F", "Dm", "Bb", "C"},
                        {"F", "Bb", "Dm", "Am", "C", "Bb"},
                        {"Gm", "Bb", "F"},
                        {"F", "Bb", "F", "C", "Bb", "F"}
                };
                break;
            case "F#":
                chordProgressions = new String[][]{
                        {"F#", "B", "C#"},
                        {"F#", "C#", "D#m", "B"},
                        {"D#m", "B", "F#", "C#"},
                        {"F#", "B", "D#m", "C#"},
                        {"D#m", "B", "C#"},
                        {"F#", "C#", "B", "C#"},
                        {"F#", "D#m", "B", "C#"},
                        {"F#", "C#", "D#m", "B", "G#m", "C#"},
                        {"G#m", "C#", "F#"},
                        {"F#", "B", "F#", "C#", "B", "F#"}
                };
                break;
            case "G":
                chordProgressions = new String[][]{
                        {"G", "C", "D"},
                        {"G", "D", "Em", "C"},
                        {"Em", "C", "G", "D"},
                        {"G", "C", "Em", "D"},
                        {"Em", "C", "D"},
                        {"G", "D", "C", "D"},
                        {"G", "Em", "C", "D"},
                        {"G", "C", "Em", "Bm", "D", "C"},
                        {"Am", "D", "G"},
                        {"G", "C", "G", "D", "C", "G"}
                };
                break;
            case "G#":
                chordProgressions = new String[][]{
                        {"G#", "C#", "D#"},
                        {"G#", "D#", "Fm", "C#"},
                        {"Fm", "C#", "G#", "D#"},
                        {"G#", "C#", "Fm", "D#"},
                        {"Fm", "C#", "D#"},
                        {"G#", "D#", "C#", "D#"},
                        {"G#", "Fm", "C#", "D#"},
                        {"G#", "C#", "Fm", "Cm", "D#", "C#"},
                        {"A#m", "D#", "G#"},
                        {"G#", "C#", "G#", "D#", "C#", "G#"}
                };
                break;
            case "A":
                chordProgressions = new String[][]{
                        {"A", "D", "E"},
                        {"A", "E", "F#m", "D"},
                        {"F#m", "D", "A", "E"},
                        {"A", "D", "F#m", "E"},
                        {"F#m", "D", "E"},
                        {"A", "E", "D", "E"},
                        {"A", "F#m", "D", "E"},
                        {"A", "D", "F#m", "C#m", "E", "D"},
                        {"Bm", "E", "A"},
                        {"A", "D", "A", "E", "D", "A"}
                };
                break;
            case "A#":
                chordProgressions = new String[][]{
                        {"A#", "D#", "Fm"},
                        {"A#", "Fm", "Gm", "D#"},
                        {"Gm", "D#", "A#", "Fm"},
                        {"A#", "D#", "Gm", "Fm"},
                        {"Gm", "D#", "Fm"},
                        {"A#", "Fm", "D#", "Fm"},
                        {"A#", "Gm", "Fm", "D#"},
                        {"A#", "D#", "Gm", "Em", "Fm", "D#"},
                        {"Cm", "D#", "G#", "A#"},
                        {"A#", "D#", "A#", "Fm", "Gm", "D#"}
                };
                break;
            case "B":
                chordProgressions = new String[][]{
                        {"B", "E", "F#m"},
                        {"B", "F#m", "G#m", "E"},
                        {"G#m", "E", "B", "F#m"},
                        {"B", "E", "G#m", "F#m"},
                        {"G#m", "E", "F#m"},
                        {"B", "E", "F#m", "G#m"},
                        {"B", "G#m", "F#m", "E"},
                        {"B", "E", "G#m", "F#m", "A", "G#m"},
                        {"C#m", "F#m", "B"},
                        {"B", "E", "B", "F#m", "G#m", "E"}
                };
                break;
            default:
                //TODO create a way to handle invalid inputs
                // I don't really need a default because there is never gonna be a case that isn't covered
                chordProgressions = new String[][]{};
                break;
        }

        // Build the chord progression string
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] chordProgression : chordProgressions) {
            for (String chord : chordProgression) {
                stringBuilder.append(chord).append(" ");
            }
            stringBuilder.append("\n"); // Add a new line after each progression
        }
        chordProgressionTextView.setText(stringBuilder.toString());

        // Return the chord progressions array
        return chordProgressions;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components.
        keySpinner = findViewById(R.id.key_spinner);
        randomizeButton = findViewById(R.id.randomize_button);
        chordProgressionTextView = findViewById(R.id.chord_progression_textview);

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.key_letters, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        keySpinner.setAdapter(adapter);

        Spinner keySpinner = findViewById(R.id.key_spinner);
        ArrayAdapter<CharSequence> keyAdapter = ArrayAdapter.createFromResource(this, R.array.key_letters, android.R.layout.simple_spinner_item);
        keyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keySpinner.setAdapter(keyAdapter);

        randomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner keySpinner = findViewById(R.id.key_spinner);
                String selectedKey = keySpinner.getSelectedItem().toString();
                String[][] keyChordProgressions = getChordProgressions(selectedKey);
                Random random = new Random();
                String[] chordProgression = keyChordProgressions[random.nextInt(keyChordProgressions.length)];
                StringBuilder stringBuilder = new StringBuilder();
                for (String chord : chordProgression) {
                    stringBuilder.append(chord).append(" ");
                }
                chordProgressionTextView.setText(stringBuilder.toString());
            }
        });

        keySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedKey = adapterView.getItemAtPosition(i).toString();
                String[] chordProgression = getRandomChordProgression(selectedKey);
                StringBuilder stringBuilder = new StringBuilder();
                for (String chord : chordProgression) {
                    stringBuilder.append(chord).append(" ");
                }
                chordProgressionTextView.setText(stringBuilder.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private String[] getRandomChordProgression(String key) {
        Random random = new Random();
        String[][] chordProgressionsForKey = getChordProgressions(key);
        return chordProgressionsForKey[random.nextInt(chordProgressionsForKey.length)];
    }
}

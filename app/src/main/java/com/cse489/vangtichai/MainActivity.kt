package com.cse489.vangtichai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cse489.vangtichai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Current amount stored as string to accurately manage keypad input
    private var currentAmountString: String = "0"

    companion object {
        private const val KEY_CURRENT_AMOUNT = "KEY_CURRENT_AMOUNT"
        private const val MAX_INPUT_LENGTH = 9 // Prevents overflow (max 999,999,999 BDT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Restore state across orientation changes
        if (savedInstanceState != null) {
            currentAmountString = savedInstanceState.getString(KEY_CURRENT_AMOUNT, "0")
        }

        setupKeypadListeners()
        updateUi()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_CURRENT_AMOUNT, currentAmountString)
    }

    private fun setupKeypadListeners() {
        val digitButtonsMap = mapOf(
            binding.btnKey0 to '0',
            binding.btnKey1 to '1',
            binding.btnKey2 to '2',
            binding.btnKey3 to '3',
            binding.btnKey4 to '4',
            binding.btnKey5 to '5',
            binding.btnKey6 to '6',
            binding.btnKey7 to '7',
            binding.btnKey8 to '8',
            binding.btnKey9 to '9'
        )

        for ((button, digit) in digitButtonsMap) {
            button.setOnClickListener {
                onDigitPressed(digit)
            }
        }

        binding.btnKeyClear.setOnClickListener {
            onClearPressed()
        }
    }

    private fun onDigitPressed(digit: Char) {
        if (currentAmountString == "0") {
            if (digit != '0') {
                currentAmountString = digit.toString()
            }
        } else {
            if (currentAmountString.length < MAX_INPUT_LENGTH) {
                currentAmountString += digit
            }
        }
        updateUi()
    }

    private fun onClearPressed() {
        currentAmountString = "0"
        updateUi()
    }

    private fun updateUi() {
        binding.tvAmount.text = currentAmountString

        val amount = currentAmountString.toLongOrNull() ?: 0L
        val notesMap = DenominationCalculator.calculateNotesMap(amount)

        binding.tvCount500.text = (notesMap[500] ?: 0L).toString()
        binding.tvCount100.text = (notesMap[100] ?: 0L).toString()
        binding.tvCount50.text = (notesMap[50] ?: 0L).toString()
        binding.tvCount20.text = (notesMap[20] ?: 0L).toString()
        binding.tvCount10.text = (notesMap[10] ?: 0L).toString()
        binding.tvCount5.text = (notesMap[5] ?: 0L).toString()
        binding.tvCount2.text = (notesMap[2] ?: 0L).toString()
        binding.tvCount1.text = (notesMap[1] ?: 0L).toString()
    }
}

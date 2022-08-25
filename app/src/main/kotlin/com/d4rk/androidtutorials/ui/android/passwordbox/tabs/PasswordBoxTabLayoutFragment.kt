package com.d4rk.androidtutorials.ui.android.passwordbox.tabs
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.d4rk.androidtutorials.R
import com.d4rk.androidtutorials.databinding.FragmentPasswordBoxLayoutBinding
import me.zhanghai.android.fastscroll.FastScrollerBuilder
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
class PasswordBoxTabLayoutFragment : Fragment() {
    private lateinit var _binding: FragmentPasswordBoxLayoutBinding
    private val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPasswordBoxLayoutBinding.inflate(inflater, container, false)
        FastScrollerBuilder(binding.textboxScrollView).useMd2Style().build()
        val inputStream: InputStream = resources.openRawResource(R.raw.text_password_xml)
        val byteArrayOutputStream = ByteArrayOutputStream()
        var i: Int
        try {
            i = inputStream.read()
            while (i != - 1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        binding.passwordBoxXMLText.text = byteArrayOutputStream.toString()
        return binding.root
    }
}
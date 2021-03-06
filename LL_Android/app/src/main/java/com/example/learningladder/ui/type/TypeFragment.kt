package com.example.learningladder.ui.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningladder.R

class TypeFragment : Fragment() {

    private lateinit var typeViewModel: TypeViewModel

    private val viewModel: TypeViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, TypeViewModel.Factory(activity.application))
                .get(TypeViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        typeViewModel =
                ViewModelProvider(this).get(TypeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_type, container, false)
        val textView: TextView = root.findViewById(R.id.text_type)
        typeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
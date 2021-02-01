package com.example.learningladder.ui.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningladder.R

class GraphFragment : Fragment() {

    private lateinit var graphViewModel: GraphViewModel

    private val viewModel: GraphViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, GraphViewModel.Factory(activity.application))
                .get(GraphViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        graphViewModel =
                ViewModelProvider(this).get(GraphViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_graph, container, false)
        val textView: TextView = root.findViewById(R.id.text_graph)
        graphViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
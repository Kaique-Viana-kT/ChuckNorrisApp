package com.rose.ChuckNorrisApp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rose.ChuckNorrisApp.R
import com.rose.ChuckNorrisApp.model.Joke
import com.rose.ChuckNorrisApp.presenter.JokeDayPresenter
import com.rose.ChuckNorrisApp.presenter.JokePresenter
import com.squareup.picasso.Picasso
import okhttp3.internal.lockAndWaitNanos

class JokeDayFragment : Fragment() {

    private lateinit var presenter: JokeDayPresenter
    private lateinit var progress: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageJoke: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokeDayPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = getString(R.string.menu_joke_day)
        progress = view.findViewById(R.id.progress)
        textView = view.findViewById(R.id.txt_joke)
        imageJoke = view.findViewById(R.id.img_joke)

        presenter.findRandom()
    }

    fun showJoke(joke: Joke){
        textView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imageJoke)
    }

    fun showProgress(){
        progress.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progress.visibility = View.GONE
    }

    fun showFailure(message: String){
        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }
}
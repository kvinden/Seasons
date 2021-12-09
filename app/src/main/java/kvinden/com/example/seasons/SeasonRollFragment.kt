package kvinden.com.example.seasons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ROLLED_IMAGE = "image"

class SeasonRollFragment : Fragment() {

    lateinit var seasonImageView: ImageView
    lateinit var rollButton: Button

    private val seasonImageList: List<Int> = listOf(
        R.drawable.autumn,
        R.drawable.winter,
        R.drawable.spring,
        R.drawable.summer,
    )

    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_season_roll, container, false)

        seasonImageView = view.findViewById(R.id.season_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            seasonImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        rollButton.setOnClickListener {
            seasonImageView.setImageResource(seasonImageList.random())
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }

}
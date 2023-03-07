import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blackjack.R
import com.example.blackjack.databinding.ListCardBinding

class BlackjackAdapter(private val dataList: MutableList<Card>) :
    RecyclerView.Adapter<BlackjackAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cardListBidng = ListCardBinding.inflate(inflater, parent, false)
//        val view = LayoutInflater.from(parent.context).inflate(
//            R.layout.list_card,
//            parent, false
//        )
        return MyViewHolder(cardListBidng)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
        val layoutParams = holder.itemView.layoutParams
        layoutParams.width = 130
        holder.itemView.requestLayout()
    }

    override fun getItemCount() = dataList.size

    inner class MyViewHolder(val binding: ListCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Card) {
            binding.textView.text = """${data.suit}
                | ${data.rank}
            """.trimMargin()
        }
    }
}
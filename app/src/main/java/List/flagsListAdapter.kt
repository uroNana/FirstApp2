package List

import FlagsList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.R

//creazione della classe View Holder
class  FlagsListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //definisci i valori riferiti a i View del layout
    val flagsText: TextView
    val flagsDrawable: ImageView

    //e associale all'id delle View
    init {
        flagsText = view.findViewById(R.id.flags_text)
        flagsDrawable = view.findViewById(R.id.flags_drawable)
    }

}
//*implement members*     *change to constructor invocation* // implementa il valore riferito alla lista della classe kotlin
class flagsListAdapter(val item: List<FlagsList>): RecyclerView.Adapter<FlagsListViewHolder>() {
    //                                                                  rimuovi List.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsListViewHolder {
        //definisci la View associata al layout della lista
        val flagsView = LayoutInflater.from(parent.context).inflate(R.layout.item_flags, parent, false)
        return  FlagsListViewHolder(flagsView)
    }

    override fun onBindViewHolder(holder: FlagsListViewHolder, position: Int) {
        //Collega i dati alla view in base alla posizione dell'elemento nella lista
        holder.flagsDrawable.setImageResource(item[position].image)

        holder.flagsText.text = item[position].name
    }

    override fun getItemCount(): Int {
        //return della dimensione della Lista
        return item.size
    }
}
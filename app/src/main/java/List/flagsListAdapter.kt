package List

import FlagsList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.databinding.ItemFlagsBinding

//creazione della classe View Holder
class  FlagsListViewHolder(val binding: ItemFlagsBinding): RecyclerView.ViewHolder(binding.root) {

    //binding degli item
    fun bind(item: FlagsList) {
        binding.flagsText.text = item.name.toString()
        binding.flagsDrawable.setImageResource(item.image)
    }
}
//*implement members*     *change to constructor invocation* // implementa il valore riferito alla lista della classe kotlin
class flagsListAdapter(): ListAdapter<FlagsList, FlagsListViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsListViewHolder {
        //Questo metodo viene chiamato dalla RecyclerView quando deve creare una nuova istanza
        // di ViewHolder per visualizzare un elemento nella posizione specificata.

        //crea una vista delle informazioni relative all'oggetto FlagsList
        val flagsView = ItemFlagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //restituisce un'istanza di FlagsListViewHolder che conterrà la vista creata.
        return  FlagsListViewHolder(flagsView)
    }

    //per confrontare gli oggetti di due diverse liste di elementi e determinare se sono gli
    // stessi elementi o se hanno gli stessi contenuti
    private class DiffCallback : DiffUtil.ItemCallback<FlagsList>() {
        override fun areItemsTheSame(oldItem: FlagsList, newItem: FlagsList) =
            oldItem == newItem
        override fun areContentsTheSame(oldItem: FlagsList, newItem: FlagsList) =
            oldItem == newItem
    }
    override fun onBindViewHolder(holder: FlagsListViewHolder, position: Int) {
        //Collega i dati alla view in base alla posizione dell'elemento nella lista
        val item = getItem(position)
        holder.bind(item)
    }

    //override fun getItemCount(): Int {
        //return della dimensione della Lista
        //return item.size
    //}
}
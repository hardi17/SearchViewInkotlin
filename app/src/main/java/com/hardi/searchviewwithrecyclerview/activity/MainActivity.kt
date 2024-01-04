package com.hardi.searchviewwithrecyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hardi.searchviewwithrecyclerview.R
import com.hardi.searchviewwithrecyclerview.adapter.SearchAdapter
import com.hardi.searchviewwithrecyclerview.data.CarModel
import com.hardi.searchviewwithrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var adapter: SearchAdapter

    lateinit var carList: ArrayList<CarModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCarList()
        setUpUI()
        searchYourCar()
    }

    private fun searchYourCar() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCar(newText)
                return true
            }

        })
    }

    private fun filterCar(newText: String?) {
        val filteredlist: ArrayList<CarModel> = ArrayList()

        // running a for loop to compare elements.
        for (item in carList) {
            // checking if the entered string matched with any item of our recycler view.
            if (newText != null) {
                if (item.carName.toLowerCase().contains(newText.toLowerCase())) {
                    // if the item is matched we are
                    // adding it to our filtered list.
                    filteredlist.add(item)
                }
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No data match..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }
    }

    /*Setting up recyclerview layout and adding adapter*/
    private fun setUpUI() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerview.context,
                (binding.recyclerview.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    /*add car name and image values into list*/
    private fun addCarList() {
        carList = ArrayList()
        carList.add(CarModel("Kia", R.drawable.ic_launcher_background))
        carList.add(CarModel("BMW", R.drawable.ic_launcher_background))
        carList.add(CarModel("Tesla", R.drawable.ic_launcher_background))
        carList.add(CarModel("Skoda", R.drawable.ic_launcher_background))
        carList.add(CarModel("Cupra", R.drawable.ic_launcher_background))
        carList.add(CarModel("MG", R.drawable.ic_launcher_background))
        carList.add(CarModel("Honda", R.drawable.ic_launcher_background))
        carList.add(CarModel("Hyundia", R.drawable.ic_launcher_background))
        carList.add(CarModel("Mercedes-Benz", R.drawable.ic_launcher_background))
        carList.add(CarModel("Volkswagen", R.drawable.ic_launcher_background))
        carList.add(CarModel("Toyota", R.drawable.ic_launcher_background))
        carList.add(CarModel("Ford", R.drawable.ic_launcher_background))
        carList.add(CarModel("Volvo", R.drawable.ic_launcher_background))
        carList.add(CarModel("Bugatti", R.drawable.ic_launcher_background))
        carList.add(CarModel("Ferrari", R.drawable.ic_launcher_background))
        carList.add(CarModel("Maruti Suzuki", R.drawable.ic_launcher_background))
        carList.add(CarModel("Lexus", R.drawable.ic_launcher_background))
        carList.add(CarModel("Audi", R.drawable.ic_launcher_background))
        carList.add(CarModel("Porsche", R.drawable.ic_launcher_background))
        carList.add(CarModel("Land Rover", R.drawable.ic_launcher_background))
        carList.add(CarModel("Jaguar", R.drawable.ic_launcher_background))

        adapter = SearchAdapter(carList)
        binding.recyclerview.adapter = adapter
    }
}
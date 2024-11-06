package com.example.numad24fa_zhiyanpei;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private Context context;
    private List<ContactModel> contactList;

    public ContactAdapter(Context context, List<ContactModel> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactModel contactModel = contactList.get(position);
        String id = contactModel.getId();
        String name = contactModel.getName();
        String phone = contactModel.getPhone();

        holder.contactName.setText(name);
        holder.contactPhone.setText(phone);
        holder.contactDial.setOnClickListener(v -> {
            if (!phone.isEmpty()) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phone));
                context.startActivity(dialIntent);
            } else {
                Toast.makeText(context, "Invalid phone number", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView contactName;
        TextView contactPhone;
        ImageView contactDial;

        public ContactViewHolder(@NonNull  View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            contactPhone = itemView.findViewById(R.id.contact_number);
            contactDial = itemView.findViewById(R.id.contact_number_dial);


        }
    }

//    public ContactModel getContactAt(int position) {
//        return contactList.get(position);
//    }
//
//    public void removeContactAt(int position) {
//        contactList.remove(position);
//    }
}

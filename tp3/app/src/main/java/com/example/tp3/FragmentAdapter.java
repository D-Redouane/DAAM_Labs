package com.example.tp3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new com.example.tp3.PositionMapFragment();
            case 1:
                return new ListChallengeFragment();
            default:
                return new com.example.tp3.PositionMapFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Deux fragments : Position Map et List Challenge
    }
}

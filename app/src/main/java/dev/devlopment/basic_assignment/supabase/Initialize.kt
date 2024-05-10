package dev.devlopment.basic_assignment.supabase

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class Initialize {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://eogedcwxsoquyanzidtk.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVvZ2VkY3d4c29xdXlhbnppZHRrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTUzMzQxODAsImV4cCI6MjAzMDkxMDE4MH0.vSp_qunJ5qti3PFst_gpRHvTqkucpjS1wgtdi7rS_og"
    ) {
        install(Postgrest)
    }
}
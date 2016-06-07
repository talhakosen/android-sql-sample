package tkosen.com.android_sql_sample.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by tctkosen on 07/06/16.
 */
public class ContryProvider extends ContentProvider {
    static final int COUNTRY = 100;
    private static final SQLiteQueryBuilder sCountriesQueryBuilder;
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    static {
        sCountriesQueryBuilder = new SQLiteQueryBuilder();
        sCountriesQueryBuilder.setTables(CountryContract.CountryEntry.TABLE_NAME);
    }

    private CountryDbHelper countryDbHelper;

    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = CountryContract.CountryEntry.CONTENT_AUTHORITY;
        matcher.addURI(authority, CountryContract.CountryEntry.PATH_COUNTRY, COUNTRY);
        return matcher;
    }

    public Cursor getCountries() {
        return countryDbHelper.getReadableDatabase().query(CountryContract.CountryEntry.TABLE_NAME, null, "", null, "", "", "");
    }

    @Override
    public boolean onCreate() {
        countryDbHelper = new CountryDbHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

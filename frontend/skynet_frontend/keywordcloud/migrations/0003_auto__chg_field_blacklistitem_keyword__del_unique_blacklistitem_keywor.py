# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Removing unique constraint on 'BlacklistItem', fields ['keyword']
        #db.delete_unique('keywordcloud_blacklistitem', ['keyword'])

        # Renaming column for 'BlacklistItem.keyword' to match new field type.
        db.rename_column('keywordcloud_blacklistitem', 'keyword', 'keyword_id')
        # Changing field 'BlacklistItem.keyword'
        db.alter_column('keywordcloud_blacklistitem', 'keyword_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Keyword']))

        # Adding index on 'BlacklistItem', fields ['keyword']
        db.create_index('keywordcloud_blacklistitem', ['keyword_id'])


    def backwards(self, orm):
        
        # Removing index on 'BlacklistItem', fields ['keyword']
        db.delete_index('keywordcloud_blacklistitem', ['keyword_id'])

        # Renaming column for 'BlacklistItem.keyword' to match new field type.
        db.rename_column('keywordcloud_blacklistitem', 'keyword_id', 'keyword')
        # Changing field 'BlacklistItem.keyword'
        db.alter_column('keywordcloud_blacklistitem', 'keyword', self.gf('django.db.models.fields.CharField')(max_length=140, unique=True))

        # Adding unique constraint on 'BlacklistItem', fields ['keyword']
        db.create_unique('keywordcloud_blacklistitem', ['keyword'])


    models = {
        'keywordcloud.blacklistitem': {
            'Meta': {'object_name': 'BlacklistItem'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Keyword']"})
        },
        'twitter.keyword': {
            'Meta': {'object_name': 'Keyword'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'unique': 'True', 'max_length': '140'})
        }
    }

    complete_apps = ['keywordcloud']

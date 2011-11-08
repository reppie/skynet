# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'BlacklistItem'
        db.create_table('keywordcloud_blacklistitem', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('keyword', self.gf('django.db.models.fields.CharField')(unique=True, max_length=140)),
        ))
        db.send_create_signal('keywordcloud', ['BlacklistItem'])


    def backwards(self, orm):
        
        # Deleting model 'BlacklistItem'
        db.delete_table('keywordcloud_blacklistitem')


    models = {
        'keywordcloud.blacklistitem': {
            'Meta': {'object_name': 'BlacklistItem'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'unique': 'True', 'max_length': '140'})
        }
    }

    complete_apps = ['keywordcloud']

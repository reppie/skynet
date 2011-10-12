# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding field 'DoesItWorkModel.is_still_working'
        db.add_column('somela_doesitworkmodel', 'is_still_working', self.gf('django.db.models.fields.BooleanField')(default=False), keep_default=False)


    def backwards(self, orm):
        
        # Deleting field 'DoesItWorkModel.is_still_working'
        db.delete_column('somela_doesitworkmodel', 'is_still_working')


    models = {
        'somela.doesitworkmodel': {
            'Meta': {'object_name': 'DoesItWorkModel'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'is_still_working': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'is_working': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'migration_worked': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['somela']

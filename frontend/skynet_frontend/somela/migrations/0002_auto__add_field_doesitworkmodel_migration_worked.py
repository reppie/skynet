# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):
    
    def forwards(self, orm):
        
        # Adding field 'DoesItWorkModel.migration_worked'
        db.add_column('somela_doesitworkmodel', 'migration_worked', self.gf('django.db.models.fields.BooleanField')(default=False, blank=True), keep_default=False)
    
    
    def backwards(self, orm):
        
        # Deleting field 'DoesItWorkModel.migration_worked'
        db.delete_column('somela_doesitworkmodel', 'migration_worked')
    
    
    models = {
        'somela.doesitworkmodel': {
            'Meta': {'object_name': 'DoesItWorkModel'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'is_working': ('django.db.models.fields.BooleanField', [], {'default': 'False', 'blank': 'True'}),
            'migration_worked': ('django.db.models.fields.BooleanField', [], {'default': 'False', 'blank': 'True'})
        }
    }
    
    complete_apps = ['somela']
